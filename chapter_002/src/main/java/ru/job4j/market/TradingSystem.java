package ru.job4j.market;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.function.Predicate;

import static ru.job4j.market.Request.*;

/**
 * Класс - трейдинговая система.
 * В систему поступают заявки. Заявки двух типов: выставить заявку и убрать с торгов.
 * Каждая заявки имеет эммитента. Это поле указывает идентификатор ценной бумаги.
 *
 * @author Andrey Sumin
 * @since 03.05.2018
 */
public class TradingSystem {
    private int idRequest = 0;
    private HashMap<Book, TreeSet<Request>> glassesBid = new HashMap<>();
    private HashMap<Book, TreeSet<Request>> glassesAsk = new HashMap<>();

    /**
     * Добавить заявку в систему.
     *
     * @param request - заявка.
     */
    public void add(Request request) {
        if (request != null) {
            request.setId(idRequest++);
            if (request.getType() == Type.delete) {
                deleteRequest(request);
            } else {
                addRequest(request);
            }
        }
    }

    /**
     * Перегруженный метод для добавления сразу нескольких заявок.
     *
     * @param requests - заявки.
     */
    public void add(Request... requests) {
        for (Request request : requests) {
            this.add(request);
        }
    }

    /**
     * Вывести стакан всех заявок данного эмитента.
     *
     * @param book - эмитент.
     * @return - Строка в виде: первый столбец мы заполняем количеством заявок на покупку.
     * Третий столбик мы заполняем количеством заявок на продажу.
     * Центральный столбей отображает цены.
     */
    public String echo(Book book) {
        TreeSet<Request> glass = glassesBid.get(book);
        if (glass == null) {
            glass = glassesAsk.get(book);
        } else {
            glass.addAll(glassesAsk.get(book));
        }
        if (glass == null) {
            return "";
        }
        ArrayList<String> list = new ArrayList<>();
        int price = 0;
        int volume = 0;
        int index = -1;
        for (Request request : glass) {
            if (request.getPrice() != price) {
                volume = request.getVolume();
                price = request.getPrice();
                index++;
            } else {
                volume += request.getVolume();
                list.remove(index);
            }
            if (request.getAction() == Action.ask) {
                list.add(volume + "\t" + price);
            } else {
                list.add("\t" + price + "\t" + volume);
            }
        }
        StringBuilder result = new StringBuilder();
        String separator = System.lineSeparator();
        for (String s : list) {
            result.append(s).append(separator);
        }
        return result.toString();
    }

    /**
     * Приватный метод, вызывается в том случае, если пришла заявка с типом delete.
     * Ищет заявку с такой же ценой, как в запросе и уменьшает количество акций на
     * число акций в запросе на удаление.
     *
     * @param request - запрос на удаление заявки.
     */
    private void deleteRequest(Request request) {
        TreeSet<Request> glass = getSetByRequest(request);
        if (glass != null) {
            for (Request request1 : glass) {
                if (request1.getPrice() == request.getPrice()) {
                    request1.setVolume(request1.getVolume() - Math.min(request1.getVolume(), request.getVolume()));
                    glass.removeIf(predicate);
                    break;
                }
            }
        }
    }

    /**
     * Добавить заявку, метод вызывается, если тип добавляемой заявки add.
     *
     * @param request - новая заявка.
     */
    private void addRequest(Request request) {
        TreeSet<Request> glass = getSetByRequest(request);
        if (glass == null) {
            glass = new TreeSet<>(comparator);
            glass.add(request);
            getMapByRequest(request).put(request.getBook(), glass);
        } else {
            glass.add(request);
        }
        deal(request);
    }

    /**
     * Получить множество заявок по эмитенту в запросе.
     *
     * @param request - запрос.
     * @return - множество заявок с тем же эмитентом, что в запросе.
     */
    private TreeSet<Request> getSetByRequest(Request request) {
        return request.getAction() == Action.bid ? glassesBid.get(request.getBook()) : glassesAsk.get(request.getBook());
    }

    /**
     * Получить Map всех заявок типа bid или ask, в зависимости от типа заявки в запросе.
     *
     * @param request - запрос.
     * @return - Map заявок bid или ask.
     */
    private HashMap<Book, TreeSet<Request>> getMapByRequest(Request request) {
        return request.getAction() == Action.bid ? glassesBid : glassesAsk;
    }

    /**
     * Заключить сделку. Если пришла заявка на покупку акций по определенной цене,
     * а в стакане уже есть заявка на продажу этих акций по удобной для покупателя
     * цене, то между ними совершается сделка (продавец продает, покупатель покупает).
     * Из стакана удаляется удовлетворенная заявка.
     *
     * @param request - запрос.
     */
    private void deal(Request request) {
        TreeSet<Request> glass;
        if (request.getAction() == Action.bid) {
            glass = glassesAsk.get(request.getBook());
            if (glass != null) {
                for (Request r : glass.descendingSet()) {
                    if (request.getVolume() == 0 || r.getPrice() > request.getPrice()) {
                        break;
                    }
                    deal(r, request);
                }
            }
        } else {
            glass = glassesBid.get(request.getBook());
            if (glass != null) {
                for (Request r : glass) {
                    if (request.getVolume() == 0 || r.getPrice() < request.getPrice()) {
                        break;
                    }
                    deal(r, request);
                }
            }
        }
        if (glass != null) {
            glass.removeIf(predicate);
            getSetByRequest(request).removeIf(predicate);
        }
    }

    /**
     * Уменьшить количество акций в одной заявке и увеличить на тоже количество
     * в другой заявке (заключение сделки).
     *
     * @param first  - первая заявка.
     * @param second - вторая заявка.
     */
    private void deal(Request first, Request second) {
        int difference = Math.min(first.getVolume(), second.getVolume());
        first.setVolume(first.getVolume() - difference);
        second.setVolume(second.getVolume() - difference);
    }

    /**
     * По данному условию заявки удаляются из стакана,
     * если они удовлетворены и кол-во акций в заявке равно 0.
     */
    private Predicate<Request> predicate = request -> request.getVolume() <= 0;

    /**
     * Все заявки в стакане сортируются по убыванию цены.
     * Если цена у заявок одинаковая, то сортировка в порядке добавления.
     */
    private Comparator<Request> comparator = (o1, o2) -> {
        int result = o2.getPrice() - o1.getPrice();
        return result != 0 ? result : o1.getId() - o2.getId();
    };
}

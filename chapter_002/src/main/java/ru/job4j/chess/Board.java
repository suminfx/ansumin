package ru.job4j.chess;

/**
 * Класс, описывающий структуры шахматной доски.
 *
 * @author Andrey Sumin
 * @since 09.03.2018
 */
public class Board {
    public static final int BOARD_MAX_INDEX = 7;
    private final Figure[] figures = new Figure[32];
    private int position = 0;

    /**
     * Добавление фигуры на доску.
     *
     * @param figure - фигура.
     */
    public void add(Figure figure) {
        this.figures[this.position++] = figure;
    }

    /**
     * Движение фигуры по доске.
     *
     * @param src - исходное положение.
     * @param dst - клетка назначения.
     * @return - true, если не были выброшены исключения.
     * @throws FigureNotFoundException - фигура не найдена.
     * @throws ImpossibleMoveException - неверная точка назначения.
     * @throws OccupiedWayException    - путь для фигуры закрыт.
     */
    public boolean move(Cell src, Cell dst) throws FigureNotFoundException, ImpossibleMoveException, OccupiedWayException {
        int index = 0;
        boolean found = false;
        for (int i = 0; i < figures.length; i++) {
            if (figures[i] != null && figures[i].position.equals(src)) {
                index = i;
                found = true;
                break;
            }
        }
        if (!found) {
            throw new FigureNotFoundException();
        }
        Cell[] way = figures[index].way(src, dst);
        if (!free(way)) {
            throw new OccupiedWayException();
        }
        figures[index] = figures[index].copy(dst);
        return true;
    }

    /**
     * Проверка - свободен ли путь от других фигур.
     *
     * @param way - путь.
     * @return - путь открыт или нет.
     */
    private boolean free(Cell[] way) {
        boolean result = true;
        for (Figure figure : figures) {
            if (figure != null) {
                for (int i = 1; i < way.length; i++) {
                    if (figure.position.equals(way[i])) {
                        result = false;
                        break;
                    }
                }
            }
        }
        return result;
    }
}

package ru.job4j.market;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

import static ru.job4j.market.Request.*;

public class TestTradingSystem {
    TradingSystem tradingSystem;

    @Before
    public void initSystem() {
        tradingSystem = new TradingSystem();
        testAddRequests();
    }

    @Test
    public void testAddRequests() {
        Request one = new Request(Book.LUKOIL, Type.add, Action.ask, 15, 100);
        Request two = new Request(Book.LUKOIL, Type.add, Action.ask, 14, 100);
        Request three = new Request(Book.LUKOIL, Type.add, Action.ask, 13, 100);
        Request four = new Request(Book.LUKOIL, Type.add, Action.bid, 13, 200);
        Request five = new Request(Book.LUKOIL, Type.add, Action.bid, 12, 100);
        Request six = new Request(Book.LUKOIL, Type.add, Action.bid, 11, 100);
        Request seven = new Request(Book.GAZPROM, Type.add, Action.ask, 15, 100);
        Request eight = new Request(Book.GAZPROM, Type.delete, Action.ask, 15, 100);
        Request nine = new Request(Book.GAZPROM, Type.add, Action.ask, 14, 100);
        Request ten = new Request(Book.GAZPROM, Type.add, Action.ask, 13, 100);
        Request eleven = new Request(Book.GAZPROM, Type.add, Action.bid, 12, 100);
        Request twelve = new Request(Book.GAZPROM, Type.add, Action.bid, 10, 200);
        Request thirteen = new Request(Book.GAZPROM, Type.add, Action.bid, 15, 100);
        Request fourteen = new Request(Book.GAZPROM, Type.add, Action.bid, 10, 100);
        tradingSystem.add(one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve, thirteen, fourteen);
    }

    @Test
    public void testEcho() {
        String resultLukoil = tradingSystem.echo(Book.LUKOIL);
        String resultGazprom = tradingSystem.echo(Book.GAZPROM);
        String resultNikel = tradingSystem.echo(Book.NIKEL);
        System.out.println(resultLukoil);
        System.out.println(resultGazprom);
        System.out.println(resultNikel);
        StringBuilder builder = new StringBuilder();
        String separator = System.lineSeparator();
        builder.append("100\t15").append(separator);
        builder.append("100\t14").append(separator);
        builder.append("\t13\t100").append(separator);
        builder.append("\t12\t100").append(separator);
        builder.append("\t11\t100").append(separator);
        String expectedLukoil = builder.toString();
        builder.setLength(0);
        builder.append("100\t14").append(separator);
        builder.append("\t12\t100").append(separator);
        builder.append("\t10\t300").append(separator);
        String expectedGazprom = builder.toString();
        builder.setLength(0);
        String expectedNikel = builder.toString();
        assertThat(resultLukoil, is(expectedLukoil));
        assertThat(resultGazprom, is(expectedGazprom));
        assertThat(resultNikel, is(expectedNikel));
    }
}

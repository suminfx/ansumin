package ru.job4j;

/**
 * Calculate Класс для вывода на экран HelloWorld
 * @author asumin
 * @since 13.02.2018
 * @version 1
 */

public class Calculate {
	/**
	 * Вывод на экран "Hello world!"
	 * @param args - аргументы командной строки
	 */
	public static void main(String[] args) {
		System.out.println("Hello world!");
	}

	/**
	 * Method echo
	 * @param name - Your name
	 * return Echo plus your name
	 */
	 String echo(String name) {
		return "Echo, echo, echo " + name;
	}
}
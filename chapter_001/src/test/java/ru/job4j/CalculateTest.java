package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author Andrey Sumin (suminfx@mail.ru)
* @version $Id$
* @since 0.1
*/
public class CalculateTest {
		/**
		* Test echo.
		*/
		@Test
		public void whenTakeNameThenThreeEchoPlusName() {
			String input = "Andrey Sumin";
			String expect = "Echo, echo, echo Andrey Sumin"; 
			Calculate calc = new Calculate();
			String result = calc.echo(input);
			assertThat(result, is(expect));
		}
}
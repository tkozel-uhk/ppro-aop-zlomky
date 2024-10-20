package cz.uhk.fim.ppro.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Zlomek jako modelova trida
 * s vyuzitim Lombok anotaci
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Zlomek {
	private int citatel;
	private int jmenovatel;
	
	public Zlomek zkratit() {
		int d = nsd(citatel, jmenovatel);
		return new Zlomek(citatel/d, jmenovatel/d);
	}

	/**
	 * Nejvetsi spolecny delitel
	 * @param a prvni cislo
	 * @param b druhe cislo
	 * @return nsd
	 */
	private int nsd(int a, int b) {
		while (b != 0) {
			int zb = a % b;
			a = b;
			b = zb;
		}
		return a;
	}
	
	
}

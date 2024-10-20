package cz.uhk.fim.ppro.tools;

import org.springframework.stereotype.Component;

import cz.uhk.fim.ppro.model.Zlomek;

@Component
public class KalkulackaImpl implements Kalkulacka {

	@Override
	public Zlomek plus(Zlomek a, Zlomek b) {
		if (a.getJmenovatel()*b.getJmenovatel() == 0) {
			throw new IllegalArgumentException("Deleni nulou");
		}
		return new Zlomek(
				a.getCitatel()*b.getJmenovatel()+b.getCitatel()*a.getJmenovatel(),
				a.getJmenovatel()*b.getJmenovatel()
		);
	}

	@Override
	public Zlomek minus(Zlomek a, Zlomek b) {
		if (a.getJmenovatel()*b.getJmenovatel() == 0) {
			throw new IllegalArgumentException("Deleni nulou");
		}
		return new Zlomek(
				a.getCitatel()*b.getJmenovatel()-b.getCitatel()*a.getJmenovatel(),
				a.getJmenovatel()*b.getJmenovatel()
		);
	}

	@Override
	public Zlomek krat(Zlomek a, Zlomek b) {
		if (a.getJmenovatel()*b.getJmenovatel() == 0) {
			throw new IllegalArgumentException("Deleni nulou");
		}
		return new Zlomek(
				a.getCitatel()*b.getCitatel(),
				a.getJmenovatel()*b.getJmenovatel()
		);
	}

	@Override
	public Zlomek deleno(Zlomek a, Zlomek b) {
		if (a.getJmenovatel()*b.getCitatel() == 0) {
			throw new IllegalArgumentException("Deleni nulou");
		}
		return new Zlomek(
				a.getCitatel()*b.getJmenovatel(),
				a.getJmenovatel()*b.getCitatel()
		);
	}

}

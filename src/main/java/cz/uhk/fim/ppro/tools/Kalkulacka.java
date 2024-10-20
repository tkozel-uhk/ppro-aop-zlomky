package cz.uhk.fim.ppro.tools;

import cz.uhk.fim.ppro.model.Zlomek;

public interface Kalkulacka {

	Zlomek plus(Zlomek a, Zlomek b);
	Zlomek minus(Zlomek a, Zlomek b);
	Zlomek krat(Zlomek a, Zlomek b);
	Zlomek deleno(Zlomek a, Zlomek b);
	
}

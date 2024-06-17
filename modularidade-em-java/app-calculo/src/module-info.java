module app.calculo {
	requires transitive app.logging;
	exports br.com.izaiasvalentim.app.calculo;
	
//	exports br.com.izaiasvalentim.app.calculo.interno
//		to app.financeiro;
	
	opens br.com.izaiasvalentim.app.calculo to app.financeiro;
	
	requires app.api;
	provides br.com.izaiasvalentim.app.Calculadora 
		with br.com.izaiasvalentim.app.calculo.CalculadoraImpl;
}
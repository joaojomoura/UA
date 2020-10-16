package aula05;

public enum Tipo {
	
	INEM { public String toString() { return "INEM"; }},
	BOMBEIROS { public String toString() { return "BOMBEIROS"; }},
	GNR { public String toString() { return "GNR"; }},
	PSP { public String toString() { return "PSP"; }},
	PJ { public String toString() { return "PJ"; }}
}

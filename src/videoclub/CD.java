package videoclub;

public enum CD implements CodBarras {

	NOVEDADES(3, 1), SEMI_NOVEDADES(2, 2), ANTIGUAS(1, 4);

	private static int codGenerico = 20000;
	private int codBarras;
	private String titulo;
	private String nombreArtista;
	private int precio;
	private int diasAlquilados;

	public int generadorCodBarras() {

		codGenerico++;

		return (codGenerico - 1);

	}
	
	

	private CD(int precio, int diasAlquilados) {

		this.precio = precio;
		this.diasAlquilados = diasAlquilados;

	}

}

package videoclub;

public enum CD {
	
	NOVEDADES(3,1), SEMI_NOVEDADES(2,2), ANTIGUAS(1,4);

	protected int codBarras;
	protected String titulo;
	protected String nombreArtista;
	protected int precio;
	protected int diasAlquilados;

	private CD(int precio, int diasAlquilados) {
	
		this.precio = precio;
		this.diasAlquilados = diasAlquilados;
	
	}


}


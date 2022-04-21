package videoclub;

public enum Pelicula implements CodBarras{
	
	NOVEDADES(3,1), SEMI_NOVEDADES(2,2), ANTIGUAS(1,4);

	private static int codGenerico = 10000;
	private int codBarras;
	private String titulo;
	private int precio;
	private int diasAlquilados;
	
	public int generadorCodBarras() {
		
		codGenerico++;
		
		return (codGenerico-1);
		
		
	}

	private Pelicula(int precio, int diasAlquilados) {
	
		this.precio = precio;
		this.diasAlquilados = diasAlquilados;
		this.codBarras = generadorCodBarras();
		
		
	}
	public int getCodBarras() {
		return codBarras;
	}
	public void setCodBarras(int codBarras) {
		this.codBarras = codBarras;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public int getDiasAlquilados() {
		return diasAlquilados;
	}
	public void setDiasAlquilados(int diasAlquilados) {
		this.diasAlquilados = diasAlquilados;
	}
	
	
	
	
	


}
	
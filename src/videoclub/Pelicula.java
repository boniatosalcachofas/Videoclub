package videoclub;

public enum Pelicula{
	
	NOVEDADES(3,1), SEMI_NOVEDADES(2,2), ANTIGUAS(1,4);

	protected int codBarras;
	protected String titulo;
	protected int precio;
	protected int diasAlquilados;

	private Pelicula(int precio, int diasAlquilados) {
	
		this.precio = precio;
		this.diasAlquilados = diasAlquilados;
	
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
	
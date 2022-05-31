package cajero;

public class CajeroAutomatico {
	private String nombre;
	private String apellido;
	private long contraseña;
	private long dni;
	private long saldo;

	public CajeroAutomatico(String nombre, String apellido, long contraseña, long dni, long saldo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.contraseña = contraseña;
		this.dni = dni;
		this.saldo = saldo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public long getContraseña() {
		return contraseña;
	}

	public void setContraseña(long contraseña) {
		this.contraseña = contraseña;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public void extraer(long monto) {
		this.saldo -= monto;
	}

	public void depositar(long monto) {
		this.saldo += monto;
	}

	public long consultar() {
		return this.saldo;
	}

}

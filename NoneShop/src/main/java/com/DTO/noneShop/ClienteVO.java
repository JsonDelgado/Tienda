package com.DTO.noneShop;

public class ClienteVO {
	
	private int cedulaCliente;
	private String direccionClient;
	private String emailClient;
	private String nombreClient;
	private String telefonoClient;
	private int id_ciudad;
	



	public ClienteVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ClienteVO(String nombreClient) {
		super();
		this.nombreClient = nombreClient;
	}
	public int getCedulaCliente() {
		return cedulaCliente;
	}
	public void setCedulaCliente(int cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}
	public String getDireccionClient() {
		return direccionClient;
	}
	public void setDireccionClient(String direccionClient) {
		this.direccionClient = direccionClient;
	}
	public String getEmailClient() {
		return emailClient;
	}
	public void setEmailClient(String emailClient) {
		this.emailClient = emailClient;
	}
	public String getNombreClient() {
		return nombreClient;
	}
	public void setNombreClient(String nombreClient) {
		this.nombreClient = nombreClient;
	}
	public String getTelefonoClient() {
		return telefonoClient;
	}
	public void setTelefonoClient(String telefonoClient) {
		this.telefonoClient = telefonoClient;
	}
	public int getId_ciudad() {
		return id_ciudad;
	}
	public void setId_ciudad(int id_ciudad) {
		this.id_ciudad = id_ciudad;
	}
	
	
}

package com.DTO.noneShop;

public class VentasVO {

	
	private static final long serialVersionUID = 1L;
	
	int codigoVenta;
	int cedulaCliente;
	int cedulaUsuario;
	double ivaVenta;
	double totalVenta;
	double valorVenta;
	
	public int getCodigoVenta() {
		return codigoVenta;
	}
	public void setCodigoVenta(int codigoVenta) {
		this.codigoVenta = codigoVenta;
	}
	public int getCedulaCliente() {
		return cedulaCliente;
	}
	public void setCedulaCliente(int cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}
	public int getCedulaUsuario() {
		return cedulaUsuario;
	}
	public void setCedulaUsuario(int cedulaUsuario) {
		this.cedulaUsuario = cedulaUsuario;
	}
	public double getIvaVenta() {
		return ivaVenta;
	}
	public void setIvaVenta(double ivaVenta) {
		this.ivaVenta = ivaVenta;
	}
	public double getTotalVenta() {
		return totalVenta;
	}
	public void setTotalVenta(double totalVenta) {
		this.totalVenta = totalVenta;
	}
	public double getValorVenta() {
		return valorVenta;
	}
	public void setValorVenta(double valorVenta) {
		this.valorVenta = valorVenta;
	}
	
	
	
}

package com.DTO.noneShop;

public class productoVO {
		private int código_producto;
		private String nombre_producto;
		private int nitproveedor;
		private double precio_compra;
		private double ivacompra;
		private double precio_venta;
		
		public int getCódigo_producto() {
			return código_producto;	
		}
		public void setCódigo_producto(int código_producto) {
			this.código_producto = código_producto;
		}
		public String getNombre_producto() {
			return nombre_producto;
		}
		public void setNombre_producto(String nombre_producto) {
			this.nombre_producto = nombre_producto;
		}
		public int getNitproveedor() {
			return nitproveedor;
		}
		public void setNitproveedor(int nitproveedor) {
			this.nitproveedor = nitproveedor;
		}
		public double getPrecio_compra() {
			return precio_compra;
		}
		public void setPrecio_compra(double precio_compra) {
			this.precio_compra = precio_compra;
		}
		public double getIvacompra() {
			return ivacompra;
		}
		public void setIvacompra(double ivacompra) {
			this.ivacompra = ivacompra;
		}
		public double getPrecio_venta() {
			return precio_venta;
		}
		public void setPrecio_venta(double precio_venta) {
			this.precio_venta = precio_venta;
		}
		
	
}
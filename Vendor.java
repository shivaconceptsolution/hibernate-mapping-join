package dal;

import java.util.Set;

public class Vendor {
  private int vendorid;
  private String vendorname;
  private Set chidren;
public int getVendorid() {
	return vendorid;
}
public void setVendorid(int vendorid) {
	this.vendorid = vendorid;
}
public String getVendorname() {
	return vendorname;
}
public void setVendorname(String vendorname) {
	this.vendorname = vendorname;
}
public Set getChidren() {
	return chidren;
}
public void setChidren(Set chidren) {
	this.chidren = chidren;
}
  
}

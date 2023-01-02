package com.api.airline.pojo;

public class CreateAirlineRequest {
	

private Integer id;
private String name;
private String country;
private String logo;
private String slogan;
private String headQuaters;
private String website;
private String established;

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getCountry() {
return country;
}

public void setCountry(String country) {
this.country = country;
}

public String getLogo() {
return logo;
}

public void setLogo(String logo) {
this.logo = logo;
}

public String getSlogan() {
return slogan;
}

public void setSlogan(String slogan) {
this.slogan = slogan;
}

public String getHeadQuaters() {
return headQuaters;
}

public void setHeadQuaters(String headQuaters) {
this.headQuaters = headQuaters;
}

public String getWebsite() {
return website;
}

public void setWebsite(String website) {
this.website = website;
}

public String getEstablished() {
return established;
}

public void setEstablished(String established) {
this.established = established;
}


}

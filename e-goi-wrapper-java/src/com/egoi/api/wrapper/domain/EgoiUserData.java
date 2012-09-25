package com.egoi.api.wrapper.domain;

/*
 Tag				Descrição
 USER_ID			ID do utilizador
 USERNNAME		Nome de utilizador
 USER_LEVEL		Tipo de utilizador
 FIRST_NAME		Nome
 LAST_NAME		Apelido
 EMAIL			Endereço de e-mail
 TELEPHONE		Telefone
 CELLPHONE		Telemóvel
 FAX				Fax
 CLIENTE_ID		ID do cliente
 APIKEY			Chave da API
 GENDER			Género
 LANGUAGE		Idioma
 */

/**
 * Represents the UserData
 * 
 * @author Luís Lobo <lflobo@gmail.com>
 */
public class EgoiUserData {

	private String id;

	private String username;

	private String userLevel;

	private String firstName;

	private String lastName;

	private String email;

	private String telephone;

	private String cellphone;

	private String fax;

	private String clienteId;

	private String apikey;

	private String gender;

	private String language;

	public EgoiUserData() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getClienteId() {
		return clienteId;
	}

	public void setClienteId(String clienteId) {
		this.clienteId = clienteId;
	}

	public String getApikey() {
		return apikey;
	}

	public void setApikey(String apikey) {
		this.apikey = apikey;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String toString() {
		return "EgoiUserData [id=" + id + ", username=" + username
				+ ", userLevel=" + userLevel + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email
				+ ", telephone=" + telephone + ", cellphone=" + cellphone
				+ ", fax=" + fax + ", clienteId=" + clienteId + ", apikey="
				+ apikey + ", gender=" + gender + ", language=" + language
				+ "]";
	}

}

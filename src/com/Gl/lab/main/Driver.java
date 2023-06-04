package com.Gl.lab.main;

import com.Gl.lab.services.CredentialServices;

public class Driver {

	public static void main(String[] args) {
		CredentialServices cs = new CredentialServices();
		cs.sessionStart();
	}

}

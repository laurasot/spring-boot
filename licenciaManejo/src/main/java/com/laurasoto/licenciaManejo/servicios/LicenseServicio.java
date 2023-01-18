package com.laurasoto.licenciaManejo.servicios;

import java.util.List;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.stereotype.Service;

import com.laurasoto.licenciaManejo.modelos.License;
import com.laurasoto.licenciaManejo.repositorios.LicenseRepositorio;


@Service
public class LicenseServicio {
	private final LicenseRepositorio licenseRepositorio;
	
	public LicenseServicio(LicenseRepositorio licenseRepositorio) {
		this.licenseRepositorio = licenseRepositorio;
	}
	
	//crea/guarda una persona
		 public License creaLicense(License nuevaLicense) {
		     return licenseRepositorio.save(nuevaLicense);
	}

		 
}

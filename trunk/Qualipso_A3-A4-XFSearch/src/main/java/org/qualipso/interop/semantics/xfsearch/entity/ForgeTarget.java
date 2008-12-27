package org.qualipso.interop.semantics.xfsearch.entity;

/*******************************************************************************
 * Copyright (c) 2007 ATOS Origin SAE, 
 * All rights reserved. This software and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     @author Jesus Gorroñogoitia, jesus.gorronogoitia@atosresearch.eu ATOS Origin SAE -
 *     @author Jesus Martin, Origin SAE -
 *     
 *******************************************************************************/


/**
 * Remote forge representation.
 * It includes the reference and service specification
 * of remote forge where the cross-forge performed 
 */
public class ForgeTarget {
	
	/** An unique identifier considered as the reference of remote forge */
	private String id;
	
	/** Service specification of remote forge */
	private ForgeServiceSpecification remoteForgeServiceSpecification;
	
	/**
	 * It creates a forge target representation
	 * @param remoteForgeReference Forge representation.
	 */
	public ForgeTarget (String remoteForgeReference){
		this.id = remoteForgeReference;
		this.remoteForgeServiceSpecification = null;
	}

	/**
	 * Default constructor
	 */
	public ForgeTarget() {}

	/**
	 * It returns the remote forge identifier
	 * @return remoteForgeReference Remote forge identifier
	 */
	public String getId() {
		return id;
	}

	/**
	 * It sets the remote forge identifier
	 * @param remoteForgeReference
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * It returns the remote forge specification
	 * @return remoteForgeServiceSpecification Remote forge specification
	 */
	public ForgeServiceSpecification getRemoteForgeServiceSpecification() {
		return remoteForgeServiceSpecification;
	}

	/**
	 * It sets the remote forge specification
	 * @param remoteForgeServiceSpecification Remote forge specification
	 */
	public void setRemoteForgeServiceSpecification(
			ForgeServiceSpecification remoteForgeServiceSpecification) {
		this.remoteForgeServiceSpecification = remoteForgeServiceSpecification;
	}
}

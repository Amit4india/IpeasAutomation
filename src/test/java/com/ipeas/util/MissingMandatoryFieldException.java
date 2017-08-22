// COPYRIGHT HEADER
//------------------------------------------------------------
// Copyright 2014 Time Warner Cable, Inc.
//
//
// This module contains unpublished, confidential, proprietary
// material.  The use and dissemination of this material are
// governed by a license.  The above copyright notice does not
// evidence any actual or intended publication of this material.
//
// Created:
// File: MissingMandatoryFieldException.java
//------------------------------------------------------------
// COPYRIGHT END

package com.ipeas.util;

public class MissingMandatoryFieldException extends Exception {
	private static final long serialVersionUID = 1L;
	private String message = null;

	public MissingMandatoryFieldException() {
		super();
	}

	public MissingMandatoryFieldException(String message) {
		super(message);
		this.message = message;
	}

	public MissingMandatoryFieldException(Throwable cause) {
		super(cause);
	}

	@Override
	public String toString() {
		return message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}

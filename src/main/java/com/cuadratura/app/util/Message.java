package com.cuadratura.app.util;

import java.io.Serializable;

public class Message implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer codError;
    private String msjError;

    public Integer getCodError() {
        return codError;
    }

    public void setCodError(Integer codError) {
        this.codError = codError;
    }

    public String getMsjError() {
        return msjError;
    }

    public void setMsjError(String msjError) {
        this.msjError = msjError;
    }

	@Override
	public String toString() {
		return "Message [codError=" + codError + ", msjError=" + msjError + "]";
	}
}

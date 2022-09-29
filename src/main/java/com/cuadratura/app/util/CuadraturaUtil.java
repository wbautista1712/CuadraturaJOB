package com.cuadratura.app.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class CuadraturaUtil {
	protected static final Log logger = LogFactory.getLog(CuadraturaUtil.class);

	public static long abs(long a) {
        return (a < 0) ? -a : a;
    }

}

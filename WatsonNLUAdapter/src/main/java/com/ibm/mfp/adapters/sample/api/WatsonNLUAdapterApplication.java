/*
 *  IBM Confidential OCO Source Materials
 *                                                                 
 *  5725-I43 Copyright IBM Corp. 2011, 2017
 *                                                                   
 *  The source code for this program is not published or otherwise
 *  divested of its trade secrets, irrespective of what has
 *  been deposited with the U.S. Copyright Office.
 *                   
 */


package com.ibm.mfp.adapters.sample.api;

import com.ibm.mfp.adapter.api.ConfigurationAPI;
import com.ibm.mfp.adapter.api.MFPJAXRSApplication;

import javax.ws.rs.core.Context;
import java.util.logging.Logger;

/**
 * Initializes the Adapter API 
 */
public class WatsonNLUAdapterApplication extends MFPJAXRSApplication {

    /**
     * The logger used by the app
     */
    static Logger logger = Logger.getLogger(WatsonNLUAdapterApplication.class.getName());

    /**
     * Injected application configuration variable (injected by the MobileFirst server)
     */
    @Context
    ConfigurationAPI configApi;

    

    /**
     * Initializes the adapter application 
     * <p>
     * Init is called by the MobileFirst Server whenever an Adapter application is deployed or reconfigured. 
     * </p>
     * 
     * @throws Exception if init fails
     */
    protected void init() throws Exception {

        logger.info("Initializing Adapter application");

        /** Write initialization logic here such as initializing connection to backend systems. **/

        logger.info("Adapter initialized!");
    }

    /**
     * Deinitilize the adapter application.
     *
     * Called by the MobileFirst server when the adapter is uninstalled.
     *
     * @throws Exception in case of an error
     */
    protected void destroy() throws Exception {
		/** Write release logic such as release connections to backend systems. **/
        logger.info("Adapter destroyed!");
    }


    protected String getPackageToScan() {
        //The package of this class will be scanned (recursively) to find JAX-RS resources.
        //It is also possible to override "getPackagesToScan" method in order to return more than one package for scanning
        return getClass().getPackage().getName();
    }
}

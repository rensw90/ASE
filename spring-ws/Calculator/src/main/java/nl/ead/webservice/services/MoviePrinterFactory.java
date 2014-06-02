package nl.ead.webservice.services;

/**
 * Description for the class MoviePrinterFactory:
 * <p/>
 * Example usage:
 * <p/>
 * <pre>
 *
 * </pre>
 *
 * @author mdkr
 * @version Copyright (c) 2012 HAN University, All rights reserved.
 */
public class MoviePrinterFactory {
    public IMoviePrinter create() {
        return new MoviePrinter();
    }
}

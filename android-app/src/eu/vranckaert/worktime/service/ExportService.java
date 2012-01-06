package eu.vranckaert.worktime.service;

import android.content.Context;
import eu.vranckaert.worktime.enums.export.CsvSeparator;

import java.io.File;
import java.util.List;

/**
 * @author Dirk Vranckaert
 * Date: 5/11/11
 * Time: 14:44
 */
public interface ExportService {
    /**
     * The extension to be used for CSV exports
     */
    public final String CSV_EXTENSTION = "csv";

    /**
     * Disk some data to a CSV file. The exported data will be stored locally.
     * @param ctx The context.
     * @param filename The name of the file <b>WITHOUT</b> the extension. Depending on the implementation the extension
     * will be automatically set. If you however specify an extension it will not be overridden but the correct
     * extension will just be added to the filename.
     * @param headers A list of strings with the values to be shown in the headers.
     * @param values A list with string-arrays containing all the values to be printed. No check is executed if the
     * number of values horizontally equals the number of headers you specified. This may be different!
     * @param separator The {@link CsvSeparator} to be used in the file.
     * @return
     */
    File exportCsvFile(Context ctx, String filename, List<String> headers, List<String[]> values, CsvSeparator separator);

}

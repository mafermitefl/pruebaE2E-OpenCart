package hook;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.CSVReaderHeaderAwareBuilder;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;

public class LeerCsv {

	public static List<Map<String, String>> readCsv(String resourcePath) {
		try {
			ClassLoader cl = Thread.currentThread().getContextClassLoader();
			InputStream is = cl.getResourceAsStream(resourcePath);

			if (is == null)
				throw new RuntimeException("No se encontró:" + resourcePath);

			CSVParser parser = new CSVParserBuilder().withSeparator(';').withIgnoreLeadingWhiteSpace(true).build();

			CSVReaderHeaderAware r = new CSVReaderHeaderAwareBuilder(new InputStreamReader(is, StandardCharsets.UTF_8))
					.withCSVParser(parser).build();

			List<Map<String, String>> rows = new ArrayList<>();
			Map<String, String> row;
			while ((row = r.readMap()) != null)
				rows.add(row);
			r.close();
			return rows;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static Collection<Object[]> toJUnitParams(List<Map<String, String>> rows, String... columns) {
		List<Object[]> out = new ArrayList<>();
		for (Map<String, String> r : rows) {
			Object[] tuple = new Object[columns.length];
			for (int i = 0; i < columns.length; i++)
				tuple[i] = r.get(columns[i]);
			out.add(tuple);
		}
		return out;
	}

}

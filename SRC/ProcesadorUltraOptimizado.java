import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ProcesadorUltraOptimizado {

    public static void procesar(String ruta) {

        Map<String, Integer> campañas = new HashMap<>(512);

        long inicio = System.currentTimeMillis();

        try (
                BufferedReader reader =
                        new BufferedReader(
                                new FileReader(ruta),
                                1024 * 1024
                        )
        ) {

            String linea;

            // Saltar encabezado
            reader.readLine();

            while ((linea = reader.readLine()) != null) {

                int inicioCampo = 0;
                int campoActual = 0;

                String ingresoStr = "";
                String segmento = "";
                String region = "";
                String scoreStr = "";
                String deudaStr = "";

                for (int i = 0; i < linea.length(); i++) {

                    if (linea.charAt(i) == ',') {

                        String valor =
                                linea.substring(inicioCampo, i);

                        switch (campoActual) {

                            case 2:
                                ingresoStr = valor;
                                break;

                            case 3:
                                segmento = valor;
                                break;

                            case 4:
                                region = valor;
                                break;

                            case 5:
                                scoreStr = valor;
                                break;

                            case 6:
                                deudaStr = valor;
                                break;
                        }

                        campoActual++;
                        inicioCampo = i + 1;

                        if (campoActual > 6) {
                            break;
                        }
                    }
                }

                double ingreso =
                        Double.parseDouble(ingresoStr);

                int score =
                        Integer.parseInt(scoreStr);

                double deuda =
                        Double.parseDouble(deudaStr);

                String campaña =
                        generarCampaña(
                                ingreso,
                                segmento,
                                region,
                                score,
                                deuda
                        );

                campañas.merge(campaña, 1, Integer::sum);
            }

        } catch (IOException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }

        long fin = System.currentTimeMillis();

        System.out.println("\n===== RESUMEN =====");

        for (Map.Entry<String, Integer> entry :
                campañas.entrySet()) {

            System.out.println(
                    entry.getKey()
                            + ": "
                            + entry.getValue()
            );
        }

        System.out.println(
                "\nTiempo ultra optimizado: "
                        + (fin - inicio)
                        + " ms"
        );
    }

    private static String generarCampaña(
            double ingreso,
            String segmento,
            String region,
            int score,
            double deuda
    ) {

        String ingresoNivel;
        String scoreNivel;
        String deudaNivel;

        if (ingreso >= 25000) {
            ingresoNivel = "INGRESO_ALTO";
        } else if (ingreso >= 15000) {
            ingresoNivel = "INGRESO_MEDIO";
        } else if (ingreso >= 10000) {
            ingresoNivel = "INGRESO_BAJO";
        } else {
            ingresoNivel = "NO_APLICA";
        }

        if (score >= 800) {
            scoreNivel = "SCORE_EXCELENTE";
        } else if (score >= 600) {
            scoreNivel = "SCORE_BUENO";
        } else if (score >= 400) {
            scoreNivel = "SCORE_REGULAR";
        } else {
            scoreNivel = "SCORE_RIESGO";
        }

        if (deuda >= 7000) {
            deudaNivel = "DEUDA_ALTA";
        } else if (deuda >= 3000) {
            deudaNivel = "DEUDA_MEDIA";
        } else {
            deudaNivel = "DEUDA_BAJA";
        }

        return segmento
                + '_'
                + region
                + '_'
                + ingresoNivel
                + '_'
                + scoreNivel
                + '_'
                + deudaNivel;
    }
}
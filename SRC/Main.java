public class Main {

    public static void main(String[] args) {

        String archivo = "clientes.csv";

        // Puedes subirlo después a 2_000_000
        int cantidadClientes = 500_000;

        System.out.println("======================================");
        System.out.println("LABORATORIO OPTIMIZADO");
        System.out.println("Julio Cesar Xam");
        System.out.println("======================================");

        long inicioTotal = System.currentTimeMillis();

        /*
         * GENERAR ARCHIVO
         */
        System.out.println("\nGenerando archivo CSV...");

        long inicioGeneracion =
                System.currentTimeMillis();

        GeneradorClientes.generarArchivo(
                archivo,
                cantidadClientes
        );

        long finGeneracion =
                System.currentTimeMillis();

        System.out.println(
                "Tiempo generación: "
                        + (finGeneracion - inicioGeneracion)
                        + " ms"
        );

        mostrarMemoria();

        /*
         * PROCESAR ARCHIVO
         */
        System.out.println(
                "\nProcesando clientes..."
        );

        long inicioProcesamiento =
                System.currentTimeMillis();

        ProcesadorUltraOptimizado.procesar(
                archivo
        );

        long finProcesamiento =
                System.currentTimeMillis();

        System.out.println(
                "\nTiempo procesamiento: "
                        + (finProcesamiento
                        - inicioProcesamiento)
                        + " ms"
        );

        mostrarMemoria();

        long finTotal =
                System.currentTimeMillis();

        System.out.println(
                "\nTiempo TOTAL: "
                        + (finTotal - inicioTotal)
                        + " ms"
        );

        System.out.println("\nFin del programa.");
        System.out.println("\nJulio Cesar Xam \n9941-24-8897");
    }

    private static void mostrarMemoria() {

        Runtime runtime =
                Runtime.getRuntime();

        long usada =
                runtime.totalMemory()
                        - runtime.freeMemory();

        long total =
                runtime.totalMemory();

        long maxima =
                runtime.maxMemory();

        System.out.println("\n===== MEMORIA JVM =====");

        System.out.println(
                "Usada : "
                        + (usada / 1024 / 1024)
                        + " MB"
        );

        System.out.println(
                "Total : "
                        + (total / 1024 / 1024)
                        + " MB"
        );

        System.out.println(
                "Máxima: "
                        + (maxima / 1024 / 1024)
                        + " MB"
        );
    }
}
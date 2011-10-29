public class WGet {
    public static void main(final String... args) throws Exception {
        try (final java.io.InputStream in = new java.net.URL(args[0]).openStream()) {
            final byte[] buf = new byte[4096];
            for (int bytesRead; (bytesRead = in.read(buf)) != -1; ) {
                System.out.write(buf, 0, bytesRead);
            }
            System.out.flush();
        }
    }
}

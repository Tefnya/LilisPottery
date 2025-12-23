package net.satisfy.earthernware.client.util;

public final class PreviewTintContext {
    private static final ThreadLocal<Integer> RGB = ThreadLocal.withInitial(() -> -1);

    public static void set(int rgb) {
        RGB.set(rgb);
    }

    public static int get() {
        return RGB.get();
    }

    public static void clear() {
        RGB.set(-1);
    }
}
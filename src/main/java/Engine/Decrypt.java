package engine;

public interface Decrypt {
    /** Подбор результатов
     *
     * @param txt
     * @return Возвращает расшифрованый текст
     */
    String BrutForce(String txt, int k, int length);

    /** Дешифровщик
     *
     * @param txt
     * @return возвращает смещённый массив на k
     */
    String CeaserDecr(char[] txt, int k);
}
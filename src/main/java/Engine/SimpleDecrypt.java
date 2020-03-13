package engine;

import java.util.Arrays;

public class SimpleDecrypt implements Decrypt {

    @Override
    public String BrutForce(String txt, int k, int length) {
        char[] txtArray = txt.toLowerCase().toCharArray();
        int numberOfLength;
        if (length == 0) {
            numberOfLength = txtArray.length;
        } else {
            numberOfLength = length;
        }
        char[] charCut = Arrays.copyOf(txtArray, numberOfLength);
        int kA;
        if (k == 0) {
            kA = 33;
        }
        else {
            kA = k;
        }
        System.out.println("Выберите необходимое смещение по k");
        if (k == 0) {
            for (int i = 0; i < kA; i++) {
                if (i == 0) {
                    System.out.println("original: ");
                }
                System.out.println("k = " + i + ": " + CeaserDecr(charCut, i));
            }
        } else {
            return CeaserDecr(charCut, kA);
        }
        return null;
    }

    @Override
    public String CeaserDecr(char[] txt, int k) {
        char[] txtRise = Arrays.copyOf(txt, txt.length);
        char[] alhabet = {'а','б','в','г','д','е','ё','ж','з','и','й','к','л','м','н','о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я'};
        for (int i = 0; i < txtRise.length; i++) {
            for (int j = 0; j < alhabet.length; j++) {
                //System.out.println("i = " + i + "; j = " + j + "; k = " + k + "; t[i] = " + txtRise[i]);
                if (txtRise[i] == alhabet[j]) {
                    if (j + k >= alhabet.length){
                        if (j + k + 1== alhabet.length) {
                            txtRise[i] = 'а';
                            break;
                        }
                        if (j + k + 1 > alhabet.length) {
                            txtRise[i] = alhabet[j + k - alhabet.length];
                            break;
                        }
                    } else {
                        txtRise[i] = alhabet[j+k];
                        break;
                    }

                }
            }
        }
        return Arrays.toString(txtRise);
    }
}
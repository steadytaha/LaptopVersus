
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.Collections;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Compare extends javax.swing.JFrame {

    Laptop firstProduct, secondProduct;
    Font winnerFont = new Font("URW Gothic", Font.BOLD, 18).deriveFont(Collections.singletonMap(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON));
    DecimalFormat formatter = new DecimalFormat("#,###");

    public Compare() {
        initComponents();

    }

    public void setData(Laptop firstProduct, Laptop secondProduct) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        this.firstProduct = firstProduct;
        this.secondProduct = secondProduct;
        displayProducts();
    }

    public void displayProducts() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException, ClassNotFoundException {

        // First product labels
        ImageIcon icon1 = new javax.swing.ImageIcon(getClass().getResource(firstProduct.getImg()));
        firstProductImageLabel.setIcon(icon1);
        firstProductHeaderLabel.setText(firstProduct.getBrand() + " " + firstProduct.getModel());
        firstProductPriceLabel.setText(formatter.format(firstProduct.getPrice()) + " TL");
        firstGPU.setText(firstProduct.getGPU());
        firstCPU.setText(firstProduct.getProcessor());
        firstRAM.setText(Integer.toString(firstProduct.getRam()) + " GB");
        firstStorage.setText((formatStorage(firstProduct.getStorage())));
        firstScreen.setText(Double.toString(firstProduct.getScreen()) + '"');
        firstWeight.setText(Double.toString(firstProduct.getWeight()) + " KG");
        firstYear.setText(Integer.toString(firstProduct.getYear()));
        firstOS.setText(firstProduct.getOperatingSystem());

        //Second Product Labels
        ImageIcon icon2 = new javax.swing.ImageIcon(getClass().getResource(secondProduct.getImg()));
        secondProductImageLabel.setIcon(icon2);
        secondProductHeaderLabel.setText(secondProduct.getBrand() + " " + secondProduct.getModel());
        secondProductPriceLabel.setText(formatter.format(secondProduct.getPrice()) + " TL");
        secondGPU.setText(secondProduct.getGPU());
        secondCPU.setText(secondProduct.getProcessor());
        secondRAM.setText(Integer.toString(secondProduct.getRam()) + " GB");
        secondStorage.setText((formatStorage(secondProduct.getStorage())));
        secondScreen.setText(Double.toString(secondProduct.getScreen()) + '"');
        secondWeight.setText(Double.toString(secondProduct.getWeight()) + " KG");
        secondYear.setText(Integer.toString(secondProduct.getYear()));
        secondOS.setText(secondProduct.getOperatingSystem());
        //ranking process
        compareForHigh("GPUScore", firstGPU, secondGPU, "int");
        compareForHigh("CPUScore", firstCPU, secondCPU, "int");
        compareForHigh("Ram", firstRAM, secondRAM, "int");
        compareForHigh("Storage", firstStorage, secondStorage, "int");
        compareForHigh("Screen", firstScreen, secondScreen, "double");
        compareForHigh("Year", firstYear, secondYear, "int");
        compareForLow("Weight", firstWeight, secondWeight, "double");

    }

    public void compareForHigh(String spec, JLabel first, JLabel second, String dataType) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, NoSuchFieldException, ClassNotFoundException {

        //accesing getSpec method
        Class laptopClass = firstProduct.getClass();
        Method getSpec = laptopClass.getMethod("get" + spec);
        //accesing setFont method
        Class labelClass = firstGPU.getClass();
        Method setFont = labelClass.getMethod("setFont", Font.class);

        if (dataType.equals("double")) {
            double score1 = ((double) getSpec.invoke(firstProduct));
            double score2 = ((double) getSpec.invoke(secondProduct));
            if (score1 > score2) {
                //change font size
                setFont.invoke(first, winnerFont);

            } else if (score2 > score1) {
                //change font size
                setFont.invoke(second, winnerFont);
            } else {
                //change font size if equal or null
                setFont.invoke(first, winnerFont);
                setFont.invoke(second, winnerFont);

            }

        } else {
            int score1 = ((int) getSpec.invoke(firstProduct));
            int score2 = ((int) getSpec.invoke(secondProduct));

            if (score1 > score2) {
                //change font size
                setFont.invoke(first, winnerFont);

            } else if (score2 > score1) {
                //change font size
                setFont.invoke(second, winnerFont);
            } else {
                //change font size if equal or null
                setFont.invoke(first, winnerFont);
                setFont.invoke(second, winnerFont);

            }

        }
        //spec scores

        //accesing label for font adjustments
    }

    public void compareForLow(String spec, JLabel first, JLabel second, String dataType) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, NoSuchFieldException, ClassNotFoundException {

        //accesing getSpec method
        Class laptopClass = firstProduct.getClass();
        Method getSpec = laptopClass.getMethod("get" + spec);
        //accesing setFont method
        Class labelClass = firstGPU.getClass();
        Method setFont = labelClass.getMethod("setFont", Font.class);

        if (dataType.equals("double")) {
            double score1 = ((double) getSpec.invoke(firstProduct));
            double score2 = ((double) getSpec.invoke(secondProduct));
            if (score1 < score2) {
                //change font size
                setFont.invoke(first, winnerFont);

            } else if (score2 < score1) {
                //change font size
                setFont.invoke(second, winnerFont);
            } else {
                //change font size if equal or null
                setFont.invoke(first, winnerFont);
                setFont.invoke(second, winnerFont);

            }

        } else {
            int score1 = ((int) getSpec.invoke(firstProduct));
            int score2 = ((int) getSpec.invoke(secondProduct));

            if (score1 < score2) {
                //change font size
                setFont.invoke(first, winnerFont);

            } else if (score2 < score1) {
                //change font size
                setFont.invoke(second, winnerFont);
            } else {
                //change font size if equal or null
                setFont.invoke(first, winnerFont);
                setFont.invoke(second, winnerFont);

            }

        }
        //spec scores

        //accesing label for font adjustments
    }

    public String formatStorage(int storage) {
        if (storage >= 1000) {
            return storage / 1000 + " TB";
        }
        return storage + " GB";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        secondGPU = new javax.swing.JLabel();
        secondStorage = new javax.swing.JLabel();
        secondProductPriceLabel = new javax.swing.JLabel();
        secondRAM = new javax.swing.JLabel();
        secondCPU = new javax.swing.JLabel();
        secondProductHeaderLabel = new javax.swing.JLabel();
        secondScreen = new javax.swing.JLabel();
        secondOS = new javax.swing.JLabel();
        secondYear = new javax.swing.JLabel();
        secondWeight = new javax.swing.JLabel();
        secondProductImageLabel = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        firstProductHeaderLabel = new javax.swing.JLabel();
        firstProductPriceLabel = new javax.swing.JLabel();
        firstGPU = new javax.swing.JLabel();
        firstCPU = new javax.swing.JLabel();
        firstRAM = new javax.swing.JLabel();
        firstStorage = new javax.swing.JLabel();
        firstScreen = new javax.swing.JLabel();
        firstWeight = new javax.swing.JLabel();
        firstYear = new javax.swing.JLabel();
        firstProductImageLabel = new javax.swing.JLabel();
        firstOS = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("compare");
        setFocusable(false);
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(900, 660));
        setUndecorated(true);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(54, 33, 89));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setEnabled(false);
        jPanel2.setMaximumSize(new java.awt.Dimension(900, 660));
        jPanel2.setMinimumSize(new java.awt.Dimension(900, 660));
        jPanel2.setPreferredSize(new java.awt.Dimension(900, 660));

        jPanel4.setBackground(new java.awt.Color(122, 71, 221));
        jPanel4.setMaximumSize(new java.awt.Dimension(220, 640));
        jPanel4.setPreferredSize(new java.awt.Dimension(280, 640));

        secondGPU.setFont(new java.awt.Font("URW Gothic", 0, 18)); // NOI18N
        secondGPU.setForeground(new java.awt.Color(255, 255, 255));
        secondGPU.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        secondGPU.setText("GPU2");
        secondGPU.setMaximumSize(new java.awt.Dimension(220, 30));
        secondGPU.setMinimumSize(new java.awt.Dimension(220, 30));
        secondGPU.setPreferredSize(new java.awt.Dimension(220, 30));

        secondStorage.setFont(new java.awt.Font("URW Gothic", 0, 18)); // NOI18N
        secondStorage.setForeground(new java.awt.Color(255, 255, 255));
        secondStorage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        secondStorage.setText("Storage2");
        secondStorage.setMaximumSize(new java.awt.Dimension(220, 30));
        secondStorage.setMinimumSize(new java.awt.Dimension(220, 30));
        secondStorage.setPreferredSize(new java.awt.Dimension(220, 30));

        secondProductPriceLabel.setFont(new java.awt.Font("URW Gothic", 0, 18)); // NOI18N
        secondProductPriceLabel.setForeground(new java.awt.Color(255, 255, 255));
        secondProductPriceLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        secondProductPriceLabel.setText("Price2");
        secondProductPriceLabel.setMaximumSize(new java.awt.Dimension(220, 30));
        secondProductPriceLabel.setMinimumSize(new java.awt.Dimension(220, 35));
        secondProductPriceLabel.setPreferredSize(new java.awt.Dimension(220, 30));

        secondRAM.setFont(new java.awt.Font("URW Gothic", 0, 18)); // NOI18N
        secondRAM.setForeground(new java.awt.Color(255, 255, 255));
        secondRAM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        secondRAM.setText("RAM2");
        secondRAM.setMaximumSize(new java.awt.Dimension(220, 30));
        secondRAM.setMinimumSize(new java.awt.Dimension(220, 30));
        secondRAM.setPreferredSize(new java.awt.Dimension(220, 30));

        secondCPU.setFont(new java.awt.Font("URW Gothic", 0, 18)); // NOI18N
        secondCPU.setForeground(new java.awt.Color(255, 255, 255));
        secondCPU.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        secondCPU.setText("CPU2");
        secondCPU.setMaximumSize(new java.awt.Dimension(220, 30));
        secondCPU.setMinimumSize(new java.awt.Dimension(220, 30));
        secondCPU.setPreferredSize(new java.awt.Dimension(220, 30));

        secondProductHeaderLabel.setFont(new java.awt.Font("URW Gothic", 1, 18)); // NOI18N
        secondProductHeaderLabel.setForeground(new java.awt.Color(255, 255, 255));
        secondProductHeaderLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        secondProductHeaderLabel.setText("brand+model (2)");
        secondProductHeaderLabel.setMaximumSize(new java.awt.Dimension(220, 40));
        secondProductHeaderLabel.setMinimumSize(new java.awt.Dimension(220, 40));
        secondProductHeaderLabel.setPreferredSize(new java.awt.Dimension(220, 40));

        secondScreen.setFont(new java.awt.Font("URW Gothic", 0, 18)); // NOI18N
        secondScreen.setForeground(new java.awt.Color(255, 255, 255));
        secondScreen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        secondScreen.setText("Screen2");
        secondScreen.setMaximumSize(new java.awt.Dimension(220, 30));
        secondScreen.setMinimumSize(new java.awt.Dimension(220, 30));
        secondScreen.setPreferredSize(new java.awt.Dimension(220, 30));

        secondOS.setFont(new java.awt.Font("URW Gothic", 0, 18)); // NOI18N
        secondOS.setForeground(new java.awt.Color(255, 255, 255));
        secondOS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        secondOS.setText("OS2");
        secondOS.setMaximumSize(new java.awt.Dimension(220, 30));
        secondOS.setMinimumSize(new java.awt.Dimension(220, 30));
        secondOS.setPreferredSize(new java.awt.Dimension(220, 30));

        secondYear.setFont(new java.awt.Font("URW Gothic", 0, 18)); // NOI18N
        secondYear.setForeground(new java.awt.Color(255, 255, 255));
        secondYear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        secondYear.setText("Year2");
        secondYear.setMaximumSize(new java.awt.Dimension(220, 30));
        secondYear.setMinimumSize(new java.awt.Dimension(220, 30));
        secondYear.setPreferredSize(new java.awt.Dimension(220, 30));

        secondWeight.setFont(new java.awt.Font("URW Gothic", 0, 18)); // NOI18N
        secondWeight.setForeground(new java.awt.Color(255, 255, 255));
        secondWeight.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        secondWeight.setText("Weight2");
        secondWeight.setMaximumSize(new java.awt.Dimension(220, 35));
        secondWeight.setMinimumSize(new java.awt.Dimension(62, 23));
        secondWeight.setPreferredSize(new java.awt.Dimension(220, 35));

        secondProductImageLabel.setText("IMAGE");
        secondProductImageLabel.setMaximumSize(new java.awt.Dimension(220, 200));
        secondProductImageLabel.setMinimumSize(new java.awt.Dimension(220, 200));
        secondProductImageLabel.setPreferredSize(new java.awt.Dimension(220, 200));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(secondProductImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(secondProductPriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(secondProductHeaderLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(secondGPU, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(secondCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(secondRAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(secondStorage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(secondScreen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(secondWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(secondYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(secondOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(secondProductImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(secondProductHeaderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(secondProductPriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(secondGPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(secondCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(secondRAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(secondStorage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(secondScreen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(secondWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(secondYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(secondOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143))
        );

        secondWeight.getAccessibleContext().setAccessibleName("");

        jPanel5.setBackground(new java.awt.Color(122, 71, 221));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(220, 640));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );

        firstProductHeaderLabel.setFont(new java.awt.Font("URW Gothic", 1, 18)); // NOI18N
        firstProductHeaderLabel.setForeground(new java.awt.Color(255, 255, 255));
        firstProductHeaderLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        firstProductHeaderLabel.setText("brand+model(1)");
        firstProductHeaderLabel.setMaximumSize(new java.awt.Dimension(220, 23));
        firstProductHeaderLabel.setMinimumSize(new java.awt.Dimension(220, 35));
        firstProductHeaderLabel.setPreferredSize(new java.awt.Dimension(220, 23));

        firstProductPriceLabel.setFont(new java.awt.Font("URW Gothic", 0, 18)); // NOI18N
        firstProductPriceLabel.setForeground(new java.awt.Color(255, 255, 255));
        firstProductPriceLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        firstProductPriceLabel.setText("Price1");
        firstProductPriceLabel.setMaximumSize(new java.awt.Dimension(220, 30));
        firstProductPriceLabel.setMinimumSize(new java.awt.Dimension(220, 35));
        firstProductPriceLabel.setPreferredSize(new java.awt.Dimension(220, 30));

        firstGPU.setFont(new java.awt.Font("URW Gothic", 0, 18)); // NOI18N
        firstGPU.setForeground(new java.awt.Color(255, 255, 255));
        firstGPU.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        firstGPU.setText("GPU1");
        firstGPU.setMaximumSize(new java.awt.Dimension(220, 30));
        firstGPU.setMinimumSize(new java.awt.Dimension(220, 35));
        firstGPU.setPreferredSize(new java.awt.Dimension(220, 30));

        firstCPU.setFont(new java.awt.Font("URW Gothic", 0, 18)); // NOI18N
        firstCPU.setForeground(new java.awt.Color(255, 255, 255));
        firstCPU.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        firstCPU.setText("CPU1");
        firstCPU.setMaximumSize(new java.awt.Dimension(220, 30));
        firstCPU.setMinimumSize(new java.awt.Dimension(220, 35));
        firstCPU.setPreferredSize(new java.awt.Dimension(220, 30));

        firstRAM.setFont(new java.awt.Font("URW Gothic", 0, 18)); // NOI18N
        firstRAM.setForeground(new java.awt.Color(255, 255, 255));
        firstRAM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        firstRAM.setText("RAM1");
        firstRAM.setMaximumSize(new java.awt.Dimension(220, 30));
        firstRAM.setMinimumSize(new java.awt.Dimension(220, 35));
        firstRAM.setPreferredSize(new java.awt.Dimension(220, 30));

        firstStorage.setFont(new java.awt.Font("URW Gothic", 0, 18)); // NOI18N
        firstStorage.setForeground(new java.awt.Color(255, 255, 255));
        firstStorage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        firstStorage.setText("Storage1");
        firstStorage.setMaximumSize(new java.awt.Dimension(220, 30));
        firstStorage.setMinimumSize(new java.awt.Dimension(220, 35));
        firstStorage.setPreferredSize(new java.awt.Dimension(220, 30));

        firstScreen.setFont(new java.awt.Font("URW Gothic", 0, 18)); // NOI18N
        firstScreen.setForeground(new java.awt.Color(255, 255, 255));
        firstScreen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        firstScreen.setText("Screen1");
        firstScreen.setMaximumSize(new java.awt.Dimension(220, 30));
        firstScreen.setMinimumSize(new java.awt.Dimension(220, 35));
        firstScreen.setPreferredSize(new java.awt.Dimension(220, 30));

        firstWeight.setFont(new java.awt.Font("URW Gothic", 0, 18)); // NOI18N
        firstWeight.setForeground(new java.awt.Color(255, 255, 255));
        firstWeight.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        firstWeight.setText("Weight1");
        firstWeight.setMaximumSize(new java.awt.Dimension(220, 30));
        firstWeight.setMinimumSize(new java.awt.Dimension(220, 35));
        firstWeight.setPreferredSize(new java.awt.Dimension(220, 30));

        firstYear.setFont(new java.awt.Font("URW Gothic", 0, 18)); // NOI18N
        firstYear.setForeground(new java.awt.Color(255, 255, 255));
        firstYear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        firstYear.setText("Year1");
        firstYear.setMaximumSize(new java.awt.Dimension(220, 30));
        firstYear.setMinimumSize(new java.awt.Dimension(220, 35));
        firstYear.setPreferredSize(new java.awt.Dimension(220, 30));

        firstProductImageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        firstProductImageLabel.setText("IMAGE");
        firstProductImageLabel.setMaximumSize(new java.awt.Dimension(220, 200));
        firstProductImageLabel.setMinimumSize(new java.awt.Dimension(220, 200));
        firstProductImageLabel.setPreferredSize(new java.awt.Dimension(220, 200));

        firstOS.setFont(new java.awt.Font("URW Gothic", 0, 18)); // NOI18N
        firstOS.setForeground(new java.awt.Color(255, 255, 255));
        firstOS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        firstOS.setText("OS1");
        firstOS.setMaximumSize(new java.awt.Dimension(220, 30));
        firstOS.setMinimumSize(new java.awt.Dimension(220, 35));
        firstOS.setPreferredSize(new java.awt.Dimension(220, 30));

        jLabel1.setFont(new java.awt.Font("URW Gothic", 3, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("GPU:");
        jLabel1.setMaximumSize(new java.awt.Dimension(50, 30));
        jLabel1.setMinimumSize(new java.awt.Dimension(50, 30));

        jLabel2.setFont(new java.awt.Font("URW Gothic", 3, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("CPU:");
        jLabel2.setMaximumSize(new java.awt.Dimension(50, 30));
        jLabel2.setMinimumSize(new java.awt.Dimension(50, 30));

        jLabel3.setFont(new java.awt.Font("URW Gothic", 3, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("RAM:");
        jLabel3.setMaximumSize(new java.awt.Dimension(50, 30));
        jLabel3.setMinimumSize(new java.awt.Dimension(50, 30));

        jLabel4.setFont(new java.awt.Font("URW Gothic", 3, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("STORAGE:");
        jLabel4.setMaximumSize(new java.awt.Dimension(50, 30));
        jLabel4.setMinimumSize(new java.awt.Dimension(50, 30));
        jLabel4.setPreferredSize(new java.awt.Dimension(53, 19));

        jLabel5.setFont(new java.awt.Font("URW Gothic", 3, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("SCREEN:");
        jLabel5.setMaximumSize(new java.awt.Dimension(50, 30));
        jLabel5.setMinimumSize(new java.awt.Dimension(50, 30));
        jLabel5.setPreferredSize(new java.awt.Dimension(53, 19));

        jLabel6.setFont(new java.awt.Font("URW Gothic", 3, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("WEIGHT");
        jLabel6.setMaximumSize(new java.awt.Dimension(50, 30));
        jLabel6.setMinimumSize(new java.awt.Dimension(50, 30));
        jLabel6.setPreferredSize(new java.awt.Dimension(53, 19));

        jLabel7.setFont(new java.awt.Font("URW Gothic", 3, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("YEAR:");
        jLabel7.setMaximumSize(new java.awt.Dimension(50, 30));
        jLabel7.setMinimumSize(new java.awt.Dimension(50, 30));
        jLabel7.setPreferredSize(new java.awt.Dimension(53, 19));

        jLabel8.setFont(new java.awt.Font("URW Gothic", 3, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("OP. SYSTEM:");
        jLabel8.setMaximumSize(new java.awt.Dimension(50, 30));
        jLabel8.setMinimumSize(new java.awt.Dimension(50, 30));
        jLabel8.setPreferredSize(new java.awt.Dimension(53, 19));

        jLabel9.setBackground(new java.awt.Color(204, 204, 204));
        jLabel9.setFont(new java.awt.Font("Lohit Telugu", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("LaptopVersus");

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));

        jButton3.setBackground(new java.awt.Color(54, 33, 89));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/icons/icons8-go-back-64.png"))); // NOI18N
        jButton3.setBorderPainted(false);
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/icons/icons8-vs-64.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton3)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)))
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(130, 130, 130))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(firstProductPriceLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(firstProductHeaderLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(firstCPU, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(firstOS, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(firstStorage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(firstScreen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(firstWeight, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(firstYear, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(firstGPU, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(firstRAM, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(firstProductImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addGap(23, 23, 23)))
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(253, 253, 253)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(427, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(firstProductImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(148, 148, 148)
                                    .addComponent(jLabel10))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(firstProductHeaderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(firstProductPriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firstGPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firstCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firstRAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firstStorage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firstScreen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firstWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firstYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firstOS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 20, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Compare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Compare().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel firstCPU;
    private javax.swing.JLabel firstGPU;
    private javax.swing.JLabel firstOS;
    private javax.swing.JLabel firstProductHeaderLabel;
    private javax.swing.JLabel firstProductImageLabel;
    private javax.swing.JLabel firstProductPriceLabel;
    private javax.swing.JLabel firstRAM;
    private javax.swing.JLabel firstScreen;
    private javax.swing.JLabel firstStorage;
    private javax.swing.JLabel firstWeight;
    private javax.swing.JLabel firstYear;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel secondCPU;
    private javax.swing.JLabel secondGPU;
    private javax.swing.JLabel secondOS;
    private javax.swing.JLabel secondProductHeaderLabel;
    private javax.swing.JLabel secondProductImageLabel;
    private javax.swing.JLabel secondProductPriceLabel;
    private javax.swing.JLabel secondRAM;
    private javax.swing.JLabel secondScreen;
    private javax.swing.JLabel secondStorage;
    private javax.swing.JLabel secondWeight;
    private javax.swing.JLabel secondYear;
    // End of variables declaration//GEN-END:variables
}

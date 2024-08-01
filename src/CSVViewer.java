import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CSVViewer extends Application {

    private ComboBox<String> comboBox;
    private Map<String, CSVRecord> recordMap = new HashMap<>();
    private Label productNameLabel;
    private GridPane gridPane;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("CSV Viewer");

        comboBox = new ComboBox<>();
        comboBox.setOnAction(e -> displayRecord(comboBox.getValue()));

        productNameLabel = new Label();

        gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        VBox gridContainer = new VBox(gridPane);
        gridContainer.setAlignment(Pos.CENTER);

        VBox vbox = new VBox(20, comboBox, gridContainer, productNameLabel);
        vbox.setAlignment(Pos.CENTER);

        loadCSV();

        StackPane root = new StackPane(vbox);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    private void loadCSV() {
        String csvFile = "src/sample.csv";
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(csvSplitBy);

                String[] paddedValues = new String[37];
                System.arraycopy(values, 0, paddedValues, 0, values.length);

                for (int i = values.length; i < paddedValues.length; i++) {
                    paddedValues[i] = "/";
                }

                CSVRecord record = new CSVRecord();
                record.setProduct(paddedValues[0]);
                record.setEbi(paddedValues[1]);
                record.setKani(paddedValues[2]);
                record.setKomugi(paddedValues[3]);
                record.setSoba(paddedValues[4]);
                record.setTamago(paddedValues[5]);
                record.setNyu(paddedValues[6]);
                record.setRakkasei(paddedValues[7]);
                record.setKurumi(paddedValues[8]);
                record.setAlmond(paddedValues[9]);
                record.setAwabi(paddedValues[10]);
                record.setIka(paddedValues[11]);
                record.setIkura(paddedValues[12]);
                record.setOrange(paddedValues[13]);
                record.setCashewNuts(paddedValues[14]);
                record.setKiwi(paddedValues[15]);
                record.setBeef(paddedValues[16]);
                record.setSesame(paddedValues[17]);
                record.setSake(paddedValues[18]);
                record.setSaba(paddedValues[19]);
                record.setSoy(paddedValues[20]);
                record.setChicken(paddedValues[21]);
                record.setBanana(paddedValues[22]);
                record.setPork(paddedValues[23]);
                record.setMatsutake(paddedValues[24]);
                record.setPeach(paddedValues[25]);
                record.setYam(paddedValues[26]);
                record.setApple(paddedValues[27]);
                record.setGelatin(paddedValues[28]);
                record.setFish(paddedValues[29]);
                record.setKcal(parseDoubleOrDefault(paddedValues[30]));
                record.setProtein(parseDoubleOrDefault(paddedValues[31]));
                record.setFat(parseDoubleOrDefault(paddedValues[32]));
                record.setCarbs(parseDoubleOrDefault(paddedValues[33]));
                record.setSugars(parseDoubleOrDefault(paddedValues[34]));
                record.setSalt(parseDoubleOrDefault(paddedValues[35]));
                record.setDietaryFiber(parseDoubleOrDefault(paddedValues[36]));

                recordMap.put(record.getProduct(), record);
                comboBox.getItems().add(record.getProduct());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayRecord(String productName) {
        CSVRecord record = recordMap.get(productName);
        if (record != null) {
            productNameLabel.setText("商品名: " + record.getProduct());

            gridPane.getChildren().clear();

            String[] texts = {
                "えび:" + record.getEbi(), "かに:" + record.getKani(), "小麦:" + record.getKomugi(),
                "そば:" + record.getSoba(), "卵:" + record.getTamago(), "乳:" + record.getNyu(),
                "落花生:" + record.getRakkasei(), "くるみ:" + record.getKurumi(), "アーモンド:" + record.getAlmond(),
                "あわび:" + record.getAwabi(), "いか:" + record.getIka(), "いくら:" + record.getIkura(),
                "オレンジ:" + record.getOrange(), "カシューナッツ:" + record.getCashewNuts(), "キウイフルーツ:" + record.getKiwi(),
                "牛肉:" + record.getBeef(), "ごま:" + record.getSesame(), "さけ:" + record.getSake(),
                "さば:" + record.getSaba(), "大豆:" + record.getSoy(), "鶏肉:" + record.getChicken(),
                "バナナ:" + record.getBanana(), "豚肉:" + record.getPork(), "まつたけ:" + record.getMatsutake(),
                "もも:" + record.getPeach(), "やまいも:" + record.getYam(), "りんご:" + record.getApple(),
                "ゼラチン:" + record.getGelatin(), "魚介類:" + record.getFish()
            };

            for (int i = 0; i < texts.length; i++) {
                Label label = new Label(texts[i]);
                if (texts[i].contains("×")) {
                    label.setStyle("-fx-border-color: black; -fx-border-width: 1px; -fx-padding: 5px; -fx-opacity: 0.1;");
                } else {
                    label.setStyle("-fx-border-color: black; -fx-border-width: 1px; -fx-padding: 5px;");
                }
                label.setAlignment(Pos.CENTER);
                label.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                GridPane.setRowIndex(label, i / 6);
                GridPane.setColumnIndex(label, i % 6);
                gridPane.getChildren().add(label);
            }

            for (int i = texts.length; i < 10; i++) {
                StackPane cell = new StackPane();
                cell.setStyle("-fx-border-color: black; -fx-border-width: 1px; -fx-padding: 5px;");
                Canvas canvas = new Canvas(100, 100);
                GraphicsContext gc = canvas.getGraphicsContext2D();
                gc.setStroke(Color.BLACK);
                gc.setLineWidth(1);
                gc.strokeLine(0, 0, 100, 100);
                gc.strokeLine(100, 0, 0, 100);
                cell.getChildren().add(canvas);
                GridPane.setRowIndex(cell, i / 6);
                GridPane.setColumnIndex(cell, i % 6);
                gridPane.getChildren().add(cell);
            }
        }
    }

    private double parseDoubleOrDefault(String value) {
        try {
            if (value == null || value.trim().isEmpty() || value.trim().equals("/")) {
                return 0.0;
            }
            return Double.parseDouble(value.trim());
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
}

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CSVViewer extends Application {

    private TableView<CSVRecord> tableView = new TableView<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("CSV Viewer");

        TableColumn<CSVRecord, String> productColumn = new TableColumn<>("商品名");
        productColumn.setCellValueFactory(new PropertyValueFactory<>("product"));

        TableColumn<CSVRecord, String> ebiColumn = new TableColumn<>("えび");
        ebiColumn.setCellValueFactory(new PropertyValueFactory<>("ebi"));

        TableColumn<CSVRecord, String> kaniColumn = new TableColumn<>("かに");
        kaniColumn.setCellValueFactory(new PropertyValueFactory<>("kani"));

        TableColumn<CSVRecord, String> komugiColumn = new TableColumn<>("小麦");
        komugiColumn.setCellValueFactory(new PropertyValueFactory<>("komugi"));

        TableColumn<CSVRecord, String> sobaColumn = new TableColumn<>("そば");
        sobaColumn.setCellValueFactory(new PropertyValueFactory<>("soba"));

        TableColumn<CSVRecord, String> tamagoColumn = new TableColumn<>("卵");
        tamagoColumn.setCellValueFactory(new PropertyValueFactory<>("tamago"));

        TableColumn<CSVRecord, String> nyuColumn = new TableColumn<>("乳");
        nyuColumn.setCellValueFactory(new PropertyValueFactory<>("nyu"));

        TableColumn<CSVRecord, String> rakkaseiColumn = new TableColumn<>("落花生");
        rakkaseiColumn.setCellValueFactory(new PropertyValueFactory<>("rakkasei"));

        TableColumn<CSVRecord, String> kurumiColumn = new TableColumn<>("くるみ");
        kurumiColumn.setCellValueFactory(new PropertyValueFactory<>("kurumi"));

        TableColumn<CSVRecord, String> almondColumn = new TableColumn<>("アーモンド");
        almondColumn.setCellValueFactory(new PropertyValueFactory<>("almond"));

        TableColumn<CSVRecord, String> awabiColumn = new TableColumn<>("あわび");
        awabiColumn.setCellValueFactory(new PropertyValueFactory<>("awabi"));

        TableColumn<CSVRecord, String> ikaColumn = new TableColumn<>("いか");
        ikaColumn.setCellValueFactory(new PropertyValueFactory<>("ika"));

        TableColumn<CSVRecord, String> ikuraColumn = new TableColumn<>("いくら");
        ikuraColumn.setCellValueFactory(new PropertyValueFactory<>("ikura"));

        TableColumn<CSVRecord, String> orangeColumn = new TableColumn<>("オレンジ");
        orangeColumn.setCellValueFactory(new PropertyValueFactory<>("orange"));

        TableColumn<CSVRecord, String> cashewNutsColumn = new TableColumn<>("カシューナッツ");
        cashewNutsColumn.setCellValueFactory(new PropertyValueFactory<>("cashewNuts"));

        TableColumn<CSVRecord, String> kiwiColumn = new TableColumn<>("キウイフルーツ");
        kiwiColumn.setCellValueFactory(new PropertyValueFactory<>("kiwi"));

        TableColumn<CSVRecord, String> beefColumn = new TableColumn<>("牛肉");
        beefColumn.setCellValueFactory(new PropertyValueFactory<>("beef"));

        TableColumn<CSVRecord, String> sesameColumn = new TableColumn<>("ごま");
        sesameColumn.setCellValueFactory(new PropertyValueFactory<>("sesame"));

        TableColumn<CSVRecord, String> sakeColumn = new TableColumn<>("さけ");
        sakeColumn.setCellValueFactory(new PropertyValueFactory<>("sake"));

        TableColumn<CSVRecord, String> sabaColumn = new TableColumn<>("さば");
        sabaColumn.setCellValueFactory(new PropertyValueFactory<>("saba"));

        TableColumn<CSVRecord, String> soyColumn = new TableColumn<>("大豆");
        soyColumn.setCellValueFactory(new PropertyValueFactory<>("soy"));

        TableColumn<CSVRecord, String> chickenColumn = new TableColumn<>("鶏肉");
        chickenColumn.setCellValueFactory(new PropertyValueFactory<>("chicken"));

        TableColumn<CSVRecord, String> bananaColumn = new TableColumn<>("バナナ");
        bananaColumn.setCellValueFactory(new PropertyValueFactory<>("banana"));

        TableColumn<CSVRecord, String> porkColumn = new TableColumn<>("豚肉");
        porkColumn.setCellValueFactory(new PropertyValueFactory<>("pork"));

        TableColumn<CSVRecord, String> matsutakeColumn = new TableColumn<>("まつたけ");
        matsutakeColumn.setCellValueFactory(new PropertyValueFactory<>("matsutake"));

        TableColumn<CSVRecord, String> peachColumn = new TableColumn<>("もも");
        peachColumn.setCellValueFactory(new PropertyValueFactory<>("peach"));

        TableColumn<CSVRecord, String> yamColumn = new TableColumn<>("やまいも");
        yamColumn.setCellValueFactory(new PropertyValueFactory<>("yam"));

        TableColumn<CSVRecord, String> appleColumn = new TableColumn<>("りんご");
        appleColumn.setCellValueFactory(new PropertyValueFactory<>("apple"));

        TableColumn<CSVRecord, String> gelatinColumn = new TableColumn<>("ゼラチン");
        gelatinColumn.setCellValueFactory(new PropertyValueFactory<>("gelatin"));

        TableColumn<CSVRecord, String> fishColumn = new TableColumn<>("魚介類");
        fishColumn.setCellValueFactory(new PropertyValueFactory<>("fish"));

        TableColumn<CSVRecord, Double> kcalColumn = new TableColumn<>("熱量(kcal)");
        kcalColumn.setCellValueFactory(new PropertyValueFactory<>("kcal"));

        TableColumn<CSVRecord, Double> proteinColumn = new TableColumn<>("たんぱく質(g)");
        proteinColumn.setCellValueFactory(new PropertyValueFactory<>("protein"));

        TableColumn<CSVRecord, Double> fatColumn = new TableColumn<>("脂質(g)");
        fatColumn.setCellValueFactory(new PropertyValueFactory<>("fat"));

        TableColumn<CSVRecord, Double> carbsColumn = new TableColumn<>("炭水化物(g)");
        carbsColumn.setCellValueFactory(new PropertyValueFactory<>("carbs"));

        TableColumn<CSVRecord, Double> sugarsColumn = new TableColumn<>("糖質(g)");
        sugarsColumn.setCellValueFactory(new PropertyValueFactory<>("sugars"));

        TableColumn<CSVRecord, Double> saltColumn = new TableColumn<>("食塩相当量(g)");
        saltColumn.setCellValueFactory(new PropertyValueFactory<>("salt"));

        TableColumn<CSVRecord, Double> dietaryFiberColumn = new TableColumn<>("食物繊維(g)");
        dietaryFiberColumn.setCellValueFactory(new PropertyValueFactory<>("dietaryFiber"));

        tableView.getColumns().add(productColumn);
        tableView.getColumns().add(ebiColumn);
        tableView.getColumns().add(kaniColumn);
        tableView.getColumns().add(komugiColumn);
        tableView.getColumns().add(sobaColumn);
        tableView.getColumns().add(tamagoColumn);
        tableView.getColumns().add(nyuColumn);
        tableView.getColumns().add(rakkaseiColumn);
        tableView.getColumns().add(kurumiColumn);
        tableView.getColumns().add(almondColumn);
        tableView.getColumns().add(awabiColumn);
        tableView.getColumns().add(ikaColumn);
        tableView.getColumns().add(ikuraColumn);
        tableView.getColumns().add(orangeColumn);
        tableView.getColumns().add(cashewNutsColumn);
        tableView.getColumns().add(kiwiColumn);
        tableView.getColumns().add(beefColumn);
        tableView.getColumns().add(sesameColumn);
        tableView.getColumns().add(sakeColumn);
        tableView.getColumns().add(sabaColumn);
        tableView.getColumns().add(soyColumn);
        tableView.getColumns().add(chickenColumn);
        tableView.getColumns().add(bananaColumn);
        tableView.getColumns().add(porkColumn);
        tableView.getColumns().add(matsutakeColumn);
        tableView.getColumns().add(peachColumn);
        tableView.getColumns().add(yamColumn);
        tableView.getColumns().add(appleColumn);
        tableView.getColumns().add(gelatinColumn);
        tableView.getColumns().add(fishColumn);
        tableView.getColumns().add(kcalColumn);
        tableView.getColumns().add(proteinColumn);
        tableView.getColumns().add(fatColumn);
        tableView.getColumns().add(carbsColumn);
        tableView.getColumns().add(sugarsColumn);
        tableView.getColumns().add(saltColumn);
        tableView.getColumns().add(dietaryFiberColumn);

        loadCSV();

        VBox vbox = new VBox(tableView);
        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void loadCSV() {
        File file = new File("src/sample.csv"); // sample.csv ファイルのパスを指定
    
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                tableView.getItems().clear(); // テーブルをクリアします
    
                // ヘッダー行をスキップします
                if ((line = br.readLine()) != null) {
                    // 何もせずにヘッダーをスキップ
                }
    
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
    
                    // フィールド数が足りない場合は空文字列で埋める
                    String[] paddedValues = new String[37];
                    for (int i = 0; i < paddedValues.length; i++) {
                        if (i < values.length) {
                            paddedValues[i] = values[i];
                        } else {
                            paddedValues[i] = i >= 30 ? "0" : "×"; // 数値フィールドの場合は "0" を、文字フィールドの場合は "×" をデフォルト値とする
                        }
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
                    record.setKcal(Double.parseDouble(paddedValues[30]));
                    record.setProtein(Double.parseDouble(paddedValues[31]));
                    record.setFat(Double.parseDouble(paddedValues[32]));
                    record.setCarbs(Double.parseDouble(paddedValues[33]));
                    record.setSugars(Double.parseDouble(paddedValues[34]));
                    record.setSalt(Double.parseDouble(paddedValues[35]));
                    record.setDietaryFiber(Double.parseDouble(paddedValues[36]));
    
                    tableView.getItems().add(record);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

package sistemabiblioteca;

import java.util.Calendar;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sistemabiblioteca.Estructuras.ArbolBinario.ArbolBinario;
import sistemabiblioteca.Idiomas.Idioma;



public class SistemaBiblioteca extends Application{

    /*Gestiona el cambio de idioma a partir del objeto idioma, creado a partir de la clase "Idioma". */
    public void cambiarIdioma(String nombreIdioma){
        
        if (nombreIdioma.equals("Español") || nombreIdioma.equals("Spanish")){
            nombreIdioma = "Español";
        } else {
            nombreIdioma = "Inglés";
        }
        
        idiomaSet = nombreIdioma;
        
        Idioma idioma=new Idioma(nombreIdioma);
        int counter = 0;
        
        lCOL = FXCollections.observableArrayList();
        int languageChooserIndex = 0;
        try {
           languageChooserIndex = languageChooser.getSelectionModel().getSelectedIndex();
        } catch (NullPointerException npe) {
           languageChooser.setPromptText(idioma.getProperty("CambiarIdioma"));
        }
        
        if (idiomaSet.equals("Español")){
            lCOL.add("Español");
            lCOL.add("Inglés");
        } else {
            lCOL.add("Spanish");
            lCOL.add("English");
        }
        EventHandler<ActionEvent> handler = languageChooser.getOnAction();
        languageChooser.setOnAction(null);
        languageChooser.setItems(lCOL);
        languageChooser.setOnAction(handler);
        languageChooser.getSelectionModel().select(languageChooserIndex);
        
        /*Cambiar idioma, panel izquierdo*/
        
        baseDatosButton.setText(idioma.getProperty("BaseDatosPI"));
        prestamosButton.setText(idioma.getProperty("PréstamosPI"));
        anulacionesButton.setText(idioma.getProperty("AnulacionesPI"));
        devolucionesButton.setText(idioma.getProperty("DevolucionesPI"));
        
        
        counter = 0;
 
        
        /*Cambio de idioma panel principal*/
        mainStage.setTitle(idioma.getProperty("SistemaBibliotecario"));
        headingBaseDatos.setText(idioma.getProperty("BasedeDatosPrincipal"));
        headingPrestamos.setText(idioma.getProperty("PréstamosTítulo"));
        headingAnulaciones.setText(idioma.getProperty("Anulaciones"));
        headingDevoluciones.setText(idioma.getProperty("Devoluciones"));
        baseDatosFilterLabel.setText(idioma.getProperty("Busquedapor"));
        
        int baseDatosFilterIndex = 0;
        try {
            baseDatosFilterIndex = baseDatosFilter.getSelectionModel().getSelectedIndex();
        } catch (NullPointerException npe){
            baseDatosFilter.setPromptText(idioma.getProperty("Criterio"));
        }
   
        String idiomas[] = {idioma.getProperty("ISBN"), 
                            idioma.getProperty("Título"),
                            idioma.getProperty("Autor"),
                            idioma.getProperty("Editorial"),
                            idioma.getProperty("País"),
                            idioma.getProperty("Temática"),
                            idioma.getProperty("Tipo"), 
                            idioma.getProperty("Edición"),
                            idioma.getProperty("Año")};
        
        
        
        counter = 0;
        for (String str: idiomas){
            baseDatosFilter.getItems().remove(counter);
            baseDatosFilter.getItems().add(counter, str);
            counter += 1;
        }
        
        baseDatosFilter.getSelectionModel().select(baseDatosFilterIndex);
        
        baseDatosSearchButton.setText(idioma.getProperty("Buscar"));
        baseDatosRevertirBusqueda.setText(idioma.getProperty("RevertirBúsqueda"));
        
        String[] BaseDatosTablaColumns = {idioma.getProperty("ISBN"),
                                    idioma.getProperty("Título"),
                                    idioma.getProperty("Autor"),
                                    idioma.getProperty("Editorial"),
                                    idioma.getProperty("País"),
                                    idioma.getProperty("Temática"),
                                    idioma.getProperty("Tipo"),
                                    idioma.getProperty("Edición"),
                                    idioma.getProperty("Año"),
                                    idioma.getProperty("Cantidad")
        };
        
        ObservableList<TableColumn> BaseDatosColumns = BaseDatosTable.getColumns();
        counter = 0;
        for (TableColumn tc: BaseDatosColumns){
            tc.setText(BaseDatosTablaColumns[counter]);
            counter++; 
        }
        
        procesarPrestamo.setText(idioma.getProperty("ProcesarPréstamo"));
        nombreCliente.setText(idioma.getProperty("Nombre"));
        cedula.setText(idioma.getProperty("Cédula"));
        
        ObservableList<TableColumn> BaseDatosOrdenColumns = OrdenTable.getColumns();
        
        counter = 0;
        for (TableColumn tc: BaseDatosOrdenColumns){
            tc.setText(BaseDatosTablaColumns[counter]);
            counter++;
        }
        
        notaBaseDatos.setText(idioma.getProperty("DebeSeleccionar"));
        
        adicionarOrden.setText(idioma.getProperty("Adicionar"));
        borrarOrden.setText(idioma.getProperty("Borrar"));
        procesarACasa.setText(idioma.getProperty("ProcesarPréstamo"));
        
        /*Cambiar lenguaje panel préstamos*/
        
        headingPrestamos.setText(idioma.getProperty("PréstamosTítulo"));
        prestamosActivosLabel.setText(idioma.getProperty("PréstamosActivos"));
        prestamosFilter.setText(idioma.getProperty("BusquedaporCódigo"));
        prestamosSearchButton.setText(idioma.getProperty("Buscar"));
        prestamosRevertirBusqueda.setText(idioma.getProperty("RevertirBúsqueda"));
        
        
        
        ObservableList<TableColumn> PrestamoTableColumns = PrestamosTable.getColumns();
        
        String[] PADTablaColumns = {
        idioma.getProperty("CódigoPréstamo"),
        idioma.getProperty("FechaPréstamo"),
        idioma.getProperty("Cliente"),
        idioma.getProperty("CédulaTabla"),
        idioma.getProperty("Libros"),
        idioma.getProperty("FechaDevolucion"),
        idioma.getProperty("Estado")};
        
        counter = 0;
        for (TableColumn tc: PrestamoTableColumns){
            tc.setText(PADTablaColumns[counter]);
            counter++;
        }
        gestionarAnulacionButton.setText(idioma.getProperty("GestionarAnulación"));
        gestionarDevolucionButton.setText(idioma.getProperty("GestionarDevolución"));
        
        /*Cambiar lenguaje para anulaciones*/
        
        headingAnulaciones.setText(idioma.getProperty("Anulaciones"));
        
        anulacionesFilter.setText(idioma.getProperty("BusquedaporCódigo"));
        anulacionesSearchButton.setText(idioma.getProperty("Buscar"));
        anulacionesRevertirBusqueda.setText(idioma.getProperty("RevertirBúsqueda"));
        
        ObservableList<TableColumn> AnulacionesTableColumns = AnulacionesTable.getColumns();
        
        counter = 0;
        for (TableColumn tc: AnulacionesTableColumns){
            tc.setText(PADTablaColumns[counter]);
            counter++;
        }
        
        /*Cambiar lenguaje para devoluciones*/
        headingDevoluciones.setText(idioma.getProperty("Devoluciones"));
        
        devolucionesFilter.setText(idioma.getProperty("BusquedaporCódigo"));
        devolucionesSearchButton.setText(idioma.getProperty("Buscar"));
        devolucionesRevertirBusqueda.setText(idioma.getProperty("RevertirBúsqueda"));
        
        ObservableList<TableColumn> DevolucionesTableColumns = DevolucionesTable.getColumns();
        
        counter = 0;
        for (TableColumn tc: DevolucionesTableColumns){
            tc.setText(PADTablaColumns[counter]);
            counter++;
        }
        
        }
    
        
    /*Columnas de Tabla de base de datos principal*/
    TableColumn <Libro, String> baseDatosAuthorColumn = new TableColumn(), baseDatosPublisherColumn = new TableColumn(), baseDatosCountryColumn = new TableColumn(), 
            baseDatosAreaColumn = new TableColumn(), baseDatosTypeColumn = new TableColumn(), baseDatosYearColumn = new TableColumn(), baseDatosTitleColumn = new TableColumn();
    TableColumn <Libro, Integer> baseDatosQuantityColumn = new TableColumn(), baseDatosEditionColumn = new TableColumn(), baseDatosIsbnColumn = new TableColumn();
    
    /*Se inicializan las variables necesarias para la ejecución del sistema.*/
    Button baseDatosSearchButton = new Button(), baseDatosRevertirBusqueda = new Button();
    ComboBox baseDatosFilter = new ComboBox(), languageChooser = new ComboBox();
    Label headingBaseDatos = new Label(), headingPrestamos = new Label(), headingAnulaciones = new Label(), headingDevoluciones = new Label(), baseDatosFilterLabel = new Label(),
            baseDatosSearchCriteriaLabel = new Label(), procesarPrestamo = new Label(), nombreCliente = new Label(), cedula = new Label(), notaBaseDatos = new Label(), prestamosActivosLabel = new Label(),
            prestamosFilter = new Label(), anulacionesFilter = new Label(), devolucionesFilter = new Label();
    Stage mainStage = new Stage();
    Button baseDatosButton, prestamosButton, anulacionesButton, devolucionesButton, adicionarOrden, borrarOrden, procesarACasa, prestamosSearchButton = new Button(), prestamosRevertirBusqueda = new Button(), gestionarAnulacionButton = new Button(),
            gestionarDevolucionButton = new Button(), anulacionesSearchButton = new Button(), anulacionesRevertirBusqueda = new Button(), devolucionesSearchButton = new Button(), devolucionesRevertirBusqueda = new Button();
    static ObservableList<Prestamo> prestamosObservableList = FXCollections.observableArrayList(), anulacionesObservableList = FXCollections.observableArrayList(),
            devolucionesObservableList = FXCollections.observableArrayList(), prestamosSearchObservableList, anulacionesSearchObservableList, devolucionesSearchObservableList;
    TableView PrestamosTable = new TableView(), BaseDatosTable = new TableView(), AnulacionesTable = new TableView(), DevolucionesTable = new TableView(), OrdenTable = new TableView();
    ObservableList<Libro> baseDatosObservableList, BaseDatosSearchObservableList = FXCollections.observableArrayList();
    ObservableList<String> lCOL = FXCollections.observableArrayList();
    
    /*Se inicializa idiomaSet en Español por default, para que el programa comience en Español.*/
    static String idiomaSet = "Español";
    
    /*Busca el árbol binario de base datos y retorna una observableList que contenga todos los libros en él. */
    public ObservableList<Libro> returnBinaryDBTable(ArbolBinario start){
        ObservableList<Libro> ol = FXCollections.observableArrayList();
        ArbolBinario.getLibrosInOrden(start.getRaiz(), ol);
        
        return ol;
    }
    
    /*Gestiona la programación gráfica y de acciones de botones y TextFields para la pantalla principal de 
    base de datos y creación de préstamos.*/
    @SuppressWarnings("ConvertToStringSwitch")
    public VBox callBaseDatos(){

        VBox panelCentral = new VBox(); 
        panelCentral.setAlignment(Pos.TOP_CENTER);
        
        /*Programación del heading -- Título*/
        headingBaseDatos = new Label("Base De Datos Principal");
        headingBaseDatos.setPrefWidth(1300);
        headingBaseDatos.setPrefHeight(120);
        headingBaseDatos.setAlignment(Pos.CENTER);
        headingBaseDatos.setStyle("-fx-font-size: 16pt;"
                + "-fx-background-color: #8a599c; "
                + "-fx-text-fill: white; "
                + "-fx-font-family: \"Verdana\";"
                + "-fx-font-weight: bold");
        panelCentral.getChildren().add(headingBaseDatos);
        
        /*Programación de barra de búsqueda*/
        
        FlowPane barraBusqueda = new FlowPane();
        barraBusqueda.setHgap(25);
        barraBusqueda.setPadding(new Insets(15));
        
        baseDatosFilterLabel = new Label("Busqueda por:");
        baseDatosFilterLabel.setMinSize(100, 20);
        baseDatosFilterLabel.setMaxSize(100, 20);
        baseDatosFilterLabel.setAlignment(Pos.CENTER);
        
        baseDatosFilter = new ComboBox();
        baseDatosFilter.getItems().addAll("ISBN", "Título", "Autor", "Editorial", "País", "Temática", "Tipo", "Edición", "Año");
        baseDatosFilter.setPromptText("Criterio");
        baseDatosFilter.setMinWidth(120);
        baseDatosFilter.setMaxWidth(120);
        
        baseDatosSearchCriteriaLabel = new Label("Título:");
        baseDatosSearchCriteriaLabel.setAlignment(Pos.CENTER);
        baseDatosSearchCriteriaLabel.setMinWidth(70);
        baseDatosSearchCriteriaLabel.setMaxWidth(70);
        
        baseDatosFilter.getSelectionModel().selectedItemProperty().addListener((x, oldValue, newValue) -> {
            baseDatosSearchCriteriaLabel.setText(newValue.toString()+":");
        });
        
        TextField baseDatosSearchTF = new TextField();
        baseDatosSearchTF.setMinWidth(420);
        baseDatosSearchTF.setMaxWidth(420);
        
        baseDatosSearchButton.setText("Buscar");
        baseDatosSearchButton.setOnAction(e -> {
            try {
                String filtro = baseDatosFilter.getValue().toString();
                System.out.println(filtro);
                
                int mode = 0; /*Descripción de modos: 1 - Por título, 2 - Por autor, 3 - Por Editorial, 4 - Por país
                        5 - Por Área Temática, 6 - Por Tipo, 7 - Por Edición, 8 - Por Año*/
                if (filtro.equals("ISBN:")) {
                    mode = 0;
                }else if (filtro.equals("Título") || filtro.equals("Title")){
                    mode = 1;
                } else if (filtro.equals("Autor") || filtro.equals("Author")) {
                    mode = 2;
                } else if (filtro.equals("Editorial") || filtro.equals("Publisher")) {
                    mode = 3;
                } else if (filtro.equals("País") || filtro.equals("Country")){
                    mode = 4;
                } else if (filtro.equals("Temática") || filtro.equals("Theme")){
                    mode = 5;
                } else if (filtro.equals("Tipo") || filtro.equals("Type")){
                    mode = 6;
                } else if (filtro.equals("Edición") || filtro.equals("Edition")){
                    mode = 7;
                } else if (filtro.equals("Año") || filtro.equals("Year")){
                    mode = 8;
                }
                
                BaseDatosSearchObservableList = Acciones.consultarBaseDatos(mode, baseDatosSearchTF.getText());
                
                if (BaseDatosSearchObservableList.isEmpty()){
                    String mensaje;
                    String title;
                    if (idiomaSet.equals("Español")){
                        mensaje = "No se encontró la búsqueda '"+baseDatosSearchTF.getText()+"', utilizando el filtro '"+filtro+"'.";
                        title = "Elemento no encontrado";
                    } else {
                        mensaje = "Keyword '"+baseDatosSearchTF.getText()+"' was not found with filter '"+filtro+"'.";
                        title = "Item not found";
                    }
                    Stage alert = new Stage(); 
                    StackPane sp = new StackPane(); 
                    alert.setTitle(title);
                    alert.initModality(Modality.APPLICATION_MODAL);

                    Label popUp = new Label(mensaje);
                    popUp.setStyle("-fx-font-family: \"Verdana\"; -fx-font-size: 18");
                    popUp.setPadding(new Insets(50));
                    sp.getChildren().add(popUp);
                    alert.setScene(new Scene(sp));
                    alert.show();
                } else {
                    BaseDatosTable.setItems(BaseDatosSearchObservableList);
                    BaseDatosTable.refresh();   
                }
                
                
                
            } catch (NullPointerException npe) {
                String title;
                String mensaje;
                
                if (idiomaSet.equals("Español")){
                    mensaje = "Se debe seleccionar un criterio antes de realizar la búsqueda.";
                    title = "Búsqueda sin criterio";
                } else {
                    mensaje = "A search criteria must be selected before searching.";
                    title = "Search without criteria";
                }
                
                npe.getStackTrace();
                Stage alert = new Stage(); 
                StackPane sp = new StackPane(); 
                alert.setTitle(title);
                alert.initModality(Modality.APPLICATION_MODAL);
                    
                Label popUp = new Label(mensaje);
                popUp.setStyle("-fx-font-family: \"Verdana\"; -fx-font-size: 18");
                popUp.setPadding(new Insets(50));
                sp.getChildren().add(popUp);
                alert.setScene(new Scene(sp));
                alert.show();
            } 
            
            
        });
        
        baseDatosRevertirBusqueda.setText("Revertir Búsqueda");
        baseDatosRevertirBusqueda.setMinSize(150, 30); baseDatosRevertirBusqueda.setMaxSize(150, 30);
        baseDatosRevertirBusqueda.setOnAction(e -> {
            baseDatosObservableList = returnBinaryDBTable(Acciones.arbolBaseDatos);
            BaseDatosTable.setItems(baseDatosObservableList);
            BaseDatosTable.refresh();
        });
        
        barraBusqueda.getChildren().addAll(baseDatosFilterLabel, baseDatosFilter, baseDatosSearchCriteriaLabel, baseDatosSearchTF, baseDatosSearchButton, baseDatosRevertirBusqueda);
        panelCentral.getChildren().add(barraBusqueda);
        
        /*Programación de tabla*/
        baseDatosIsbnColumn = new TableColumn("ISBN");
        baseDatosIsbnColumn.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
        baseDatosIsbnColumn.setStyle("-fx-alignment: center");
        
        baseDatosTitleColumn = new TableColumn("Titulo");
        baseDatosTitleColumn.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        baseDatosTitleColumn.setStyle("-fx-alignment: center");
        
        baseDatosAuthorColumn = new TableColumn("Autor");
        baseDatosAuthorColumn.setCellValueFactory(new PropertyValueFactory<>("autor"));
        baseDatosAuthorColumn.setStyle("-fx-alignment: center");
        
        baseDatosPublisherColumn = new TableColumn("Editorial");
        baseDatosPublisherColumn.setCellValueFactory(new PropertyValueFactory<>("editorial"));
        baseDatosPublisherColumn.setStyle("-fx-alignment: center");
        
        baseDatosCountryColumn = new TableColumn("País");
        baseDatosCountryColumn.setCellValueFactory(new PropertyValueFactory<>("pais"));
        baseDatosCountryColumn.setStyle("-fx-alignment: center");
        
        baseDatosAreaColumn = new TableColumn("Área");
        baseDatosAreaColumn.setCellValueFactory(new PropertyValueFactory<>("area"));
        baseDatosAreaColumn.setStyle("-fx-alignment: center");
        
        baseDatosTypeColumn = new TableColumn("Tipo");
        baseDatosTypeColumn.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        baseDatosTypeColumn.setStyle("-fx-alignment: center");
        
        baseDatosEditionColumn = new TableColumn("Edición");
        baseDatosEditionColumn.setCellValueFactory(new PropertyValueFactory<>("edicion"));
        baseDatosEditionColumn.setStyle("-fx-alignment: center");
        
        baseDatosYearColumn = new TableColumn("Año");
        baseDatosYearColumn.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        baseDatosYearColumn.setStyle("-fx-alignment: center");
        
        baseDatosQuantityColumn = new TableColumn("Cantidad");
        baseDatosQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        baseDatosQuantityColumn.setStyle("-fx-alignment: center");
        
        BaseDatosTable = new TableView<>();
        
        baseDatosObservableList = returnBinaryDBTable(Acciones.arbolBaseDatos);
        BaseDatosTable.setItems(baseDatosObservableList);
        
        BaseDatosTable.getColumns().addAll(baseDatosIsbnColumn, baseDatosTitleColumn, baseDatosAuthorColumn, baseDatosPublisherColumn, baseDatosCountryColumn, baseDatosAreaColumn, baseDatosTypeColumn, baseDatosEditionColumn, baseDatosYearColumn, baseDatosQuantityColumn);
        BaseDatosTable.setFixedCellSize(50);
        BaseDatosTable.setMaxHeight(250);
        
        panelCentral.getChildren().add(BaseDatosTable);
        
        /*Programación de Gestión de Préstamos*/
        
        procesarPrestamo = new Label("Procesar Préstamo (Introduzca datos del cliente)");
        procesarPrestamo.setPadding(new Insets(10,10,0,10));
        
        procesarPrestamo.setStyle("-fx-font-size: 16pt;"
                + "-fx-text-fill: black; "
                + "-fx-font-family: \"Verdana\";"
                + "-fx-font-weight: bold");
        
        panelCentral.getChildren().add(procesarPrestamo);
        
        FlowPane datosCliente = new FlowPane(); 
        datosCliente.setPadding(new Insets(10));
        datosCliente.setHgap(20);
        
        nombreCliente = new Label("Nombre:");
        nombreCliente.setAlignment(Pos.CENTER);
        nombreCliente.setMinSize(63, 35); nombreCliente.setMaxSize(63, 35);
        TextField nombreClienteTF = new TextField();
        nombreClienteTF.setMinWidth(700);
        
        cedula = new Label("Cédula:");
        cedula.setMinSize(50, 35); cedula.setMaxSize(50, 35);
        cedula.setAlignment(Pos.CENTER);
        TextField cedulaClienteTF = new TextField(); 
        
        //ComboBox tipoPrestamo = new ComboBox(); 
        //tipoPrestamo.getItems().addAll("Casa", "Sala");
        //tipoPrestamo.setPromptText("Seleccionar Tipo de Préstamo");
        
        datosCliente.getChildren().addAll(nombreCliente, nombreClienteTF, cedula, cedulaClienteTF);
        panelCentral.getChildren().add(datosCliente);
        
        /*Tabla de orden*/
        
        TableColumn<Libro, Integer> isbnColumn2 = new TableColumn("ISBN");
        isbnColumn2.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
        isbnColumn2.setStyle("-fx-alignment: center");
        
        TableColumn<Libro, String> titleColumn2 = new TableColumn("Titulo");
        titleColumn2.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        titleColumn2.setStyle("-fx-alignment: center");
        
        TableColumn<Libro, String> authorColumn2 = new TableColumn("Autor");
        authorColumn2.setCellValueFactory(new PropertyValueFactory<>("autor"));
        authorColumn2.setStyle("-fx-alignment: center");
        
        TableColumn<Libro, String> publisherColumn2 = new TableColumn("Editorial");
        publisherColumn2.setCellValueFactory(new PropertyValueFactory<>("editorial"));
        publisherColumn2.setStyle("-fx-alignment: center");
        
        TableColumn<Libro, String> countryColumn2 = new TableColumn("País");
        countryColumn2.setCellValueFactory(new PropertyValueFactory<>("pais"));
        countryColumn2.setStyle("-fx-alignment: center");
        
        TableColumn<Libro, String> areaColumn2 = new TableColumn("Área");
        areaColumn2.setCellValueFactory(new PropertyValueFactory<>("area"));
        areaColumn2.setStyle("-fx-alignment: center");
        
        TableColumn<Libro, String> typeColumn2 = new TableColumn("Tipo");
        typeColumn2.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        typeColumn2.setStyle("-fx-alignment: center");
        
        TableColumn<Libro, Integer> editionColumn2 = new TableColumn("Edición");
        editionColumn2.setCellValueFactory(new PropertyValueFactory<>("edicion"));
        editionColumn2.setStyle("-fx-alignment: center");
        
        TableColumn<Libro, String> yearColumn2 = new TableColumn("Año");
        yearColumn2.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        yearColumn2.setStyle("-fx-alignment: center");
        
        OrdenTable = new TableView();
        
        ObservableList<Libro> orderList = FXCollections.observableArrayList();
        OrdenTable.setItems(orderList);
        
        OrdenTable.getColumns().addAll(isbnColumn2, titleColumn2, authorColumn2, publisherColumn2, countryColumn2, areaColumn2, typeColumn2, editionColumn2, yearColumn2);
        OrdenTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        OrdenTable.setMaxHeight(250);
        OrdenTable.setFixedCellSize(50);
        
        panelCentral.getChildren().add(OrdenTable);
        
        notaBaseDatos = new Label("Debe seleccionar el libro de la tabla de arriba para adicionar libros a la orden.");
        notaBaseDatos.setPadding(new Insets(5,0,0,0));
        panelCentral.getChildren().add(notaBaseDatos);
        
        
        /*Programación de botones*/
        
        adicionarOrden = new Button("Adicionar"); 
        adicionarOrden.setPrefSize(150, 20);
        
        adicionarOrden.setOnAction(e -> {        
            ObservableList<Libro> libs = BaseDatosTable.getSelectionModel().getSelectedItems();
            
            for (Libro l: libs){
                if (l.getCantidad()>1){
                    OrdenTable.getItems().add(l);
                    l.setCantidad(l.getCantidad()-1);
                    BaseDatosTable.refresh();
                } else {
                    String mensaje, title; 
                    if (idiomaSet.equals("Español")){
                        mensaje = "Libro '"+l.getTitulo()+"' no se puede prestar. Solo una unidad restante para préstamo de sala.";
                        title = "Préstamo no se puede procesar";
                    } else {
                        mensaje = "Book '"+l.getTitulo()+"' cannot be lend. Only one unit left for on-site lending.";
                        title = "Loan cannot be processed";
                    }
                    Stage alert = new Stage(); 
                    StackPane sp = new StackPane(); 
                    alert.setTitle(title);
                    alert.initModality(Modality.APPLICATION_MODAL);
                    
                    Label popUp = new Label(mensaje);
                    popUp.setStyle("-fx-font-family: \"Verdana\"; -fx-font-size: 18");
                    popUp.setPadding(new Insets(50));
                    sp.getChildren().add(popUp);
                    alert.setScene(new Scene(sp));
                    alert.show();
                }
            } 
            
        });

        borrarOrden = new Button("Borrar"); 
        borrarOrden.setOnAction(e -> {
            ObservableList<Libro> bookSelected, allBooks;
            
            bookSelected = OrdenTable.getSelectionModel().getSelectedItems();
            allBooks = OrdenTable.getItems(); 
            
            for (Libro l: baseDatosObservableList){
                for (Libro l2: bookSelected){
                    if (l.getISBN()==l2.getISBN()){
                        l.setCantidad(l.getCantidad()+1);
                        BaseDatosTable.refresh();
                    }
                }
            }
            
            bookSelected.forEach(allBooks::remove);
            
            
            
        });
        borrarOrden.setPrefSize(150, 20);
        
        procesarACasa = new Button("Procesar Préstamo"); 
        procesarACasa.setStyle("-fx-background-color: #e65f25; -fx-text-fill: white; -fx-font-weight: bold");
        procesarACasa.setPrefSize(170, 20);
        
        procesarACasa.setOnAction(e -> {
            if (nombreClienteTF.getText().equals("") || cedulaClienteTF.getText().equals("") || orderList.isEmpty()){
                    String mensaje, title;
                    if (idiomaSet.equals("Español")){
                        mensaje = "Se deben rellenar todos los campos y almacenar al menos un libro antes de continuar con el préstamo.";
                        title = "Préstamo no se puede procesar";
                    } else {
                        mensaje = "All fields must be used, and at least 1 book has to be selected, in order to continue with this loan.";
                        title = "Loan cannot be proccessed.";
                    }
                    Stage alert = new Stage(); 
                    StackPane sp = new StackPane(); 
                    alert.setTitle(title);
                    alert.initModality(Modality.APPLICATION_MODAL);
                    
                    Label popUp = new Label(mensaje);
                    popUp.setStyle("-fx-font-family: \"Verdana\"; -fx-font-size: 18");
                    popUp.setPadding(new Insets(50));
                    sp.getChildren().add(popUp);
                    alert.setScene(new Scene(sp));
                    alert.showAndWait();
            } else {
                try {
                    Integer.parseInt(cedulaClienteTF.getText());
                    
                } catch (NumberFormatException nfe){
                        String mensaje, title;
                        if (idiomaSet.equals("Español")){
                            mensaje = "La cédula debe ser un valor numérico de máximo 9 digítos.";
                            title = "Préstamo no se puede procesar";
                        } else {
                            mensaje = "ID must be a 9-digit (maximum) number";
                            title = "Loan cannot be proccessed.";
                        }
                        Stage alert = new Stage(); 
                        StackPane sp = new StackPane(); 
                        alert.setTitle(title);
                        alert.initModality(Modality.APPLICATION_MODAL);

                        Label popUp = new Label(mensaje);
                        popUp.setStyle("-fx-font-family: \"Verdana\"; -fx-font-size: 18");
                        popUp.setPadding(new Insets(50));
                        sp.getChildren().add(popUp);
                        alert.setScene(new Scene(sp));
                        alert.show();
                }
                
                Libro[] tempVector = new Libro[orderList.size()];
            
            int counter = 0;
            for (Libro l: orderList){
                tempVector[counter] = l;
                counter += 1;
            }
            
            Prestamo prestamo = new Prestamo(nombreClienteTF.getText(), Integer.parseInt(cedulaClienteTF.getText()), (Calendar.DAY_OF_MONTH+"/"+Calendar.MONTH+"/"+Calendar.YEAR), (Calendar.DAY_OF_MONTH+5+"/"+Calendar.MONTH+"/"+Calendar.YEAR));
            prestamo.setLibros(tempVector);
            Acciones.prestar(prestamo);
            
            String mensaje2, title2;
                if (idiomaSet.equals("Español")){
                mensaje2 = "El préstamo fue gestionado exitosamente.";
                title2 = "Préstamo gestionado existosamente.";
            } else {
                mensaje2 = "Loan entry has been created successfully.";
                title2 = "Loan processed successfully";
            }
            
            Stage alert = new Stage();
            alert.setTitle(title2);
            alert.initModality(Modality.APPLICATION_MODAL);

            StackPane sp = new StackPane();
            Label success = new Label(mensaje2);
            sp.getChildren().add(success);

            alert.setScene(new Scene(sp, 500, 100));
            alert.showAndWait();

            OrdenTable.getItems().clear();
            OrdenTable.refresh();
            BaseDatosTable.getSelectionModel().clearSelection();
            nombreClienteTF.clear();
            cedulaClienteTF.clear();
            }
            
            
        });
        
        FlowPane barraBotones = new FlowPane(); 
        barraBotones.setPadding(new Insets(50));
        barraBotones.setAlignment(Pos.CENTER);
        barraBotones.setHgap(50);
        barraBotones.getChildren().addAll(adicionarOrden, borrarOrden, procesarACasa);
        panelCentral.getChildren().add(barraBotones);
        
        if (idiomaSet.equals("Español")){
            this.cambiarIdioma("Español");
        } else {
            this.cambiarIdioma("Inglés");
        }

        return panelCentral;
    }
    
    /*Gestiona la programación gráfica y de acciones de botones y TextFields para la pantalla principal de 
    gestión de préstamos.*/
    public VBox callPrestamos(){
        
        VBox panelCentral = new VBox(); 
        panelCentral.setAlignment(Pos.TOP_CENTER);
        
        /*Programación del título*/
        headingPrestamos = new Label("Préstamos");
        headingPrestamos.setPrefWidth(1300);
        headingPrestamos.setPrefHeight(120);
        headingPrestamos.setAlignment(Pos.CENTER);
        headingPrestamos.setStyle("-fx-font-size: 16pt;"
                + "-fx-background-color: #8a599c; "
                + "-fx-text-fill: white; "
                + "-fx-font-family: \"Verdana\";"
                + "-fx-font-weight: bold");
        panelCentral.getChildren().add(headingPrestamos);

        prestamosActivosLabel = new Label("Préstamos Activos");
        prestamosActivosLabel.setStyle("-fx-font-size: 16pt;"
                + "-fx-text-fill: black; "
                + "-fx-font-family: \"Verdana\";"
                + "-fx-font-weight: bold");
        prestamosActivosLabel.setPadding(new Insets(10,10,0,10));
        
        panelCentral.getChildren().add(prestamosActivosLabel);
        
        /*Programación panel de búsqueda*/
        
        FlowPane barraBusqueda = new FlowPane();
        barraBusqueda.setHgap(25);
        barraBusqueda.setPadding(new Insets(15));
        
        prestamosFilter = new Label("Busqueda por código de préstamo:");
        prestamosFilter.setMinSize(235, 35); prestamosFilter.setMaxSize(235, 35);
        
        TextField PrestamosSearchTF = new TextField();
        PrestamosSearchTF.setMinWidth(530);
        PrestamosSearchTF.setMaxWidth(530);
        
        prestamosSearchButton = new Button("Buscar");
        prestamosSearchButton.setOnAction(e -> {
            try {
                prestamosSearchObservableList = Acciones.consultarPrestamos(PrestamosSearchTF.getText());
                
                if (prestamosSearchObservableList.isEmpty()){
                    String mensaje, title; 
                    if (idiomaSet.equals("Español")){
                        mensaje = "No se encontró el código '"+PrestamosSearchTF.getText()+"'.";
                        title = "Elemento no encontrado";
                    } else {
                        mensaje = "Loan ID: '"+PrestamosSearchTF.getText()+"' not found.";
                        title = "Item not found";
                    }
                    
                    Stage alert = new Stage(); 
                    StackPane sp = new StackPane(); 
                    alert.setTitle(title);
                    alert.initModality(Modality.APPLICATION_MODAL);

                    Label popUp = new Label(mensaje);
                    popUp.setStyle("-fx-font-family: \"Verdana\"; -fx-font-size: 18");
                    popUp.setPadding(new Insets(50));
                    sp.getChildren().add(popUp);
                    alert.setScene(new Scene(sp));
                    alert.show();
                } else {
                    PrestamosTable.setItems(prestamosSearchObservableList);
                    PrestamosTable.refresh();
                }
            } catch (NumberFormatException nfe){
                String mensaje, title; 
                if (idiomaSet.equals("Español")){
                    mensaje = "El código debe ser un número.";
                    title = "Error de búsqueda";
                } else {
                    mensaje = "Loan ID must be a number.";
                    title = "Search Error";
                }
                
                Stage alert = new Stage(); 
                StackPane sp = new StackPane(); 
                alert.setTitle(title);
                alert.initModality(Modality.APPLICATION_MODAL);

                Label popUp = new Label(mensaje);
                popUp.setStyle("-fx-font-family: \"Verdana\"; -fx-font-size: 18");
                popUp.setPadding(new Insets(50));
                sp.getChildren().add(popUp);
                alert.setScene(new Scene(sp));
                alert.show();
            }
            
            
        });
        
        prestamosRevertirBusqueda = new Button("Revertir Búsqueda");
        prestamosRevertirBusqueda.setMinSize(143, 35); 
        prestamosRevertirBusqueda.setMaxSize(143, 35);
        prestamosRevertirBusqueda.setOnAction(e -> {
            prestamosObservableList.clear();
            Acciones.arbolPrestamos.getPrestamosInOrden(Acciones.arbolPrestamos.getRaiz(), prestamosObservableList);
            PrestamosTable.setItems(prestamosObservableList);
            PrestamosTable.refresh();
        });
        
        barraBusqueda.getChildren().addAll(prestamosFilter, PrestamosSearchTF, prestamosSearchButton, prestamosRevertirBusqueda);
        panelCentral.getChildren().add(barraBusqueda);
        
        /*Programación Tabla*/
        
        TableColumn<Prestamo, Integer> codigoPrestamoColumn = new TableColumn("Código Préstamo");
        codigoPrestamoColumn.setCellValueFactory(new PropertyValueFactory<>("codigoPrestamo"));
        codigoPrestamoColumn.setStyle("-fx-alignment: center");
        
        TableColumn<Prestamo, Integer> fechaPrestamoColumn = new TableColumn("Fecha Préstamo");
        fechaPrestamoColumn.setCellValueFactory(new PropertyValueFactory<>("fechaSolicitud"));
        fechaPrestamoColumn.setStyle("-fx-alignment: center");
        
        TableColumn<Prestamo, String> nombreClienteColumn = new TableColumn("Cliente");
        nombreClienteColumn.setCellValueFactory(new PropertyValueFactory<>("nombreCliente"));
        nombreClienteColumn.setStyle("-fx-alignment: center");
        
        TableColumn<Prestamo, Integer> cedulaColumn = new TableColumn("Cédula");
        cedulaColumn.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        cedulaColumn.setStyle("-fx-alignment: center");
        
        TableColumn<Prestamo, String> librosColumn = new TableColumn("Libros");
        librosColumn.setCellValueFactory(new PropertyValueFactory<>("click"));
        librosColumn.setStyle("-fx-alignment: center");
        
        TableColumn<Prestamo, String> fechaDevolucionColumn = new TableColumn("Fecha Devolución");
        fechaDevolucionColumn.setCellValueFactory(new PropertyValueFactory<>("fechaDevolucion"));
        fechaDevolucionColumn.setStyle("-fx-alignment: center");
        
        TableColumn<Prestamo, String> estadoColumn = new TableColumn("Estado");
        estadoColumn.setCellValueFactory(new PropertyValueFactory<>("estado"));
        estadoColumn.setStyle("-fx-alignment: center");
        
        PrestamosTable = new TableView<>();
        
        PrestamosTable.setItems(prestamosObservableList);
        
        PrestamosTable.getColumns().addAll(codigoPrestamoColumn, fechaPrestamoColumn, nombreClienteColumn, cedulaColumn, librosColumn, fechaDevolucionColumn, estadoColumn);
        PrestamosTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        PrestamosTable.setFixedCellSize(50);
        PrestamosTable.setMinHeight(400);
        
        PrestamosTable.setOnMousePressed(e -> {
            if (e.getClickCount()==2){
                Stage details = new Stage(); 
                VBox vbx = new VBox(); 
                vbx.setSpacing(20);
                vbx.setAlignment(Pos.CENTER);
                vbx.setPadding(new Insets(10));
                details.setTitle("Detalles del préstamo");
                details.initModality(Modality.APPLICATION_MODAL);
                
                Label nombreClientePopUp = new Label();
                Label fechaSolicitudPopUp = new Label(); 
                Label fechaDevolucionPopUp = new Label(); 
                Label estadoPopUp = new Label(); 
                Label cedulaPopUp = new Label(); 
                Label librosPopUp = new Label(); 
                
                
                ObservableList<Prestamo> ol = PrestamosTable.getSelectionModel().getSelectedItems();
                Prestamo pres = new Prestamo();
                
                for (Prestamo p: ol){
                    pres = p;
                }
                
                String librosPrestamo = "";
                for (Libro l: pres.getLibros()){
                    librosPrestamo += l.getTitulo()+" ";
                }
                
                if (idiomaSet.equals("Español")){
                    nombreClientePopUp.setText("Nombre del cliente: "+pres.getNombreCliente());
                    fechaSolicitudPopUp.setText("Fecha de Solicitud: "+pres.getFechaSolicitud());
                    fechaDevolucionPopUp.setText("Fecha de devolución: "+pres.getFechaDevolucion());
                    estadoPopUp.setText("Estado del préstamo: "+pres.getEstado());
                    cedulaPopUp.setText("Cédula: "+pres.getCedula());
                    librosPopUp.setText("Libros prestados: "+librosPrestamo);
                    
                } else {
                    nombreClientePopUp.setText("Customer name: "+pres.getNombreCliente());
                    fechaSolicitudPopUp.setText("Date of Entry: "+pres.getFechaSolicitud());
                    fechaDevolucionPopUp.setText("Date of return: "+pres.getFechaDevolucion());
                    estadoPopUp.setText("Loan State: "+pres.getEstado());
                    cedulaPopUp.setText("Customer ID: "+pres.getCedula());
                    librosPopUp.setText("Books lent: "+librosPrestamo);
                }
                
                
                
                vbx.getChildren().addAll(nombreClientePopUp, cedulaPopUp, librosPopUp, fechaSolicitudPopUp, fechaDevolucionPopUp, estadoPopUp); 
                details.setScene(new Scene(vbx, 500,300));
                details.show();
            }
        });
        
        panelCentral.getChildren().add(PrestamosTable);
        
        /*Programación de las acciones de anulación y devolución.*/
        
        FlowPane buttonPane = new FlowPane(); 
        buttonPane.setHgap(100);
        buttonPane.setPadding(new Insets(20));
        buttonPane.setAlignment(Pos.CENTER);
        buttonPane.setMinHeight(200);
        
        gestionarAnulacionButton = new Button("Gestionar Anulación");
        gestionarAnulacionButton.setPrefSize(250, 100);
        
        gestionarAnulacionButton.setOnAction(e -> {
            ObservableList<Prestamo> presOb = PrestamosTable.getSelectionModel().getSelectedItems();
            
            if (presOb.get(0)==null){
                String mensaje, title;
                
                if (idiomaSet.equals("Español")){
                    mensaje = "Debes seleccionar algún préstamo de la tabla para continuar.";
                    title = "No se puede gestionar anulación.";
                } else {
                    mensaje = "You must select a loan entry from the table to continue.";
                    title = "Loan voiding cannot be processed";
                }
                Stage alert = new Stage();
                alert.setTitle(title);
                alert.initModality(Modality.APPLICATION_MODAL);
                
                StackPane sp = new StackPane(); 
                
                Label alertLabel = new Label(mensaje); 
                sp.getChildren().add(alertLabel);
                
                alert.setScene(new Scene(sp, 500,100));
                alert.showAndWait();
            } else {
                Acciones.anular(presOb);
                PrestamosTable.refresh();
            }
  
        });
        
        gestionarDevolucionButton = new Button("Gestionar Devolución"); 
        gestionarDevolucionButton.setPrefSize(250, 100);
        gestionarDevolucionButton.setOnAction(e -> {
            ObservableList<Prestamo> presOb = PrestamosTable.getSelectionModel().getSelectedItems();
            
            if (presOb.get(0)==null){
                String mensaje, title; 
                
                if (idiomaSet.equals("Español")){
                    mensaje = "Debes seleccionar algún préstamo de la tabla para continuar.";
                    title = "No se puede gestionar devolución.";
                } else {
                    mensaje = "You must select a loan entry from the table to continue.";
                    title = "Book return cannot be processed";
                }
                
                Stage alert = new Stage();
                alert.setTitle(title);
                alert.initModality(Modality.APPLICATION_MODAL);
                
                StackPane sp = new StackPane(); 
                
                Label alertLabel = new Label(mensaje); 
                sp.getChildren().add(alertLabel);
                
                alert.setScene(new Scene(sp, 500,100));
                alert.showAndWait();
            } else {
                Acciones.devolver(presOb);
                PrestamosTable.refresh();
            }

        });
        
        buttonPane.getChildren().addAll(gestionarAnulacionButton, gestionarDevolucionButton);
        
        panelCentral.getChildren().add(buttonPane);
        
        if (idiomaSet.equals("Español")){
            this.cambiarIdioma("Español");
        } else {
            this.cambiarIdioma("Inglés");
        }
        
        return panelCentral;
    }
    
    /*Gestiona la programación gráfica y de acciones de botones y TextFields para la pantalla principal de 
    anulaciones de préstamos.*/
    public VBox callAnulaciones(){

        VBox panelCentral = new VBox(); 
        panelCentral.setAlignment(Pos.TOP_CENTER);
        
        /*Programación del Título*/
        
        headingAnulaciones = new Label("Anulaciones");
        headingAnulaciones.setPrefWidth(1300);
        headingAnulaciones.setPrefHeight(120);
        headingAnulaciones.setAlignment(Pos.CENTER);
        headingAnulaciones.setStyle("-fx-font-size: 16pt;"
                + "-fx-background-color: #8a599c; "
                + "-fx-text-fill: white; "
                + "-fx-font-family: \"Verdana\";"
                + "-fx-font-weight: bold");
        panelCentral.getChildren().add(headingAnulaciones);
        
        /*Programación Barra de Búsqueda*/
        
        FlowPane barraBusqueda = new FlowPane();
        barraBusqueda.setHgap(25);
        barraBusqueda.setPadding(new Insets(15));
        
        anulacionesFilter = new Label("Busqueda por código de préstamo:");
        anulacionesFilter.setMinSize(233, 35); anulacionesFilter.setMaxSize(233, 35);
        anulacionesFilter.setAlignment(Pos.CENTER);
        
        TextField AnulacionesSearchTF = new TextField();
        AnulacionesSearchTF.setMinWidth(520);
        AnulacionesSearchTF.setMaxWidth(520);
        
        anulacionesSearchButton = new Button("Buscar");
        anulacionesSearchButton.setOnAction(e -> {
            try {
                anulacionesSearchObservableList = Acciones.consultarAnulaciones(AnulacionesSearchTF.getText());
                
                if (anulacionesSearchObservableList.isEmpty()){
                    String mensaje, title; 
                    
                    if (idiomaSet.equals("Español")){
                        mensaje = "No se encontró el código de préstamo anulado '"+AnulacionesSearchTF.getText()+"'.";
                        title = "Elemento no encontrado";
                    } else {
                        mensaje = "Voided Loan ID '"+AnulacionesSearchTF.getText()+"' not found.";
                        title = "Item not found";
                    }
                    
                    Stage alert = new Stage(); 
                    StackPane sp = new StackPane(); 
                    alert.setTitle(title);
                    alert.initModality(Modality.APPLICATION_MODAL);

                    Label popUp = new Label(mensaje);
                    popUp.setStyle("-fx-font-family: \"Verdana\"; -fx-font-size: 18");
                    popUp.setPadding(new Insets(50));
                    sp.getChildren().add(popUp);
                    alert.setScene(new Scene(sp));
                    alert.show();
                } else {
                    AnulacionesTable.setItems(anulacionesSearchObservableList);
                    AnulacionesTable.refresh();
                }
            } catch (NumberFormatException nfe){
                String mensaje, title; 
                
                if (idiomaSet.equals("Español")){
                    mensaje = "El código de préstamo anulado debe ser un número.";
                    title = "Error de búsqueda";
                } else {
                    mensaje = "Voided Loan ID must be a number";
                    title = "Search Error";
                }
                
                Stage alert = new Stage();
                StackPane sp = new StackPane(); 
                alert.setTitle(title);
                alert.initModality(Modality.APPLICATION_MODAL);
                
                Label popUp = new Label(mensaje);
                popUp.setStyle("-fx-font-family: \"Verdana\"; -fx-font-size: 18");
                popUp.setPadding(new Insets(50));
                sp.getChildren().add(popUp);
                
                alert.setScene(new Scene(sp));
                alert.show();
            }
            
        });
        
        anulacionesRevertirBusqueda = new Button("Revertir Búsqueda");
        anulacionesRevertirBusqueda.setMinSize(150, 30); anulacionesRevertirBusqueda.setMaxSize(150, 30);
        anulacionesRevertirBusqueda.setOnAction(e -> {
            anulacionesObservableList.clear();
            Acciones.listaAnulados.recorridoDobleEnlazada(anulacionesObservableList);
            AnulacionesTable.setItems(anulacionesObservableList);
            AnulacionesTable.refresh();
        });
        
        barraBusqueda.getChildren().addAll(anulacionesFilter, AnulacionesSearchTF, anulacionesSearchButton, anulacionesRevertirBusqueda);
        panelCentral.getChildren().add(barraBusqueda);
        
        /*Programación de tabla*/

        TableColumn<Prestamo, Integer> codigoPrestamoColumn = new TableColumn("Código Préstamo");
        codigoPrestamoColumn.setCellValueFactory(new PropertyValueFactory<>("codigoPrestamo"));
        codigoPrestamoColumn.setStyle("-fx-alignment: center");
        
        TableColumn<Prestamo, Integer> fechaPrestamoColumn = new TableColumn("Fecha Préstamo");
        fechaPrestamoColumn.setCellValueFactory(new PropertyValueFactory<>("fechaSolicitud"));
        fechaPrestamoColumn.setStyle("-fx-alignment: center");
        
        TableColumn<Prestamo, String> nombreClienteColumn = new TableColumn("Cliente");
        nombreClienteColumn.setCellValueFactory(new PropertyValueFactory<>("nombreCliente"));
        nombreClienteColumn.setStyle("-fx-alignment: center");
        
        TableColumn<Prestamo, Integer> cedulaColumn = new TableColumn("Cédula");
        cedulaColumn.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        cedulaColumn.setStyle("-fx-alignment: center");
        
        TableColumn<Prestamo, String> librosColumn = new TableColumn("Libros");
        librosColumn.setCellValueFactory(new PropertyValueFactory<>("click"));
        librosColumn.setStyle("-fx-alignment: center");
        
        TableColumn<Prestamo, String> fechaDevolucionColumn = new TableColumn("Fecha Devolución");
        fechaDevolucionColumn.setCellValueFactory(new PropertyValueFactory<>("fechaDevolucion"));
        fechaDevolucionColumn.setStyle("-fx-alignment: center");
        
        TableColumn<Prestamo, String> estadoColumn = new TableColumn("Estado");
        estadoColumn.setCellValueFactory(new PropertyValueFactory<>("estado"));
        estadoColumn.setStyle("-fx-alignment: center");
        
        AnulacionesTable = new TableView<>();
        AnulacionesTable.setItems(anulacionesObservableList);
        AnulacionesTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        AnulacionesTable.setMinHeight(700);
        
        AnulacionesTable.getColumns().addAll(codigoPrestamoColumn, fechaPrestamoColumn, nombreClienteColumn, cedulaColumn, librosColumn, fechaDevolucionColumn, estadoColumn);
  
        panelCentral.getChildren().add(AnulacionesTable);
        
        if (idiomaSet.equals("Español")){
            this.cambiarIdioma("Español");
        } else {
            this.cambiarIdioma("Inglés");
        }
        
        return panelCentral;
    }
    
    /*Gestiona la programación gráfica y de acciones de botones y TextFields para la pantalla principal de 
    devoluciones de préstamos.*/
    public VBox callDevoluciones(){
        
        VBox panelCentral = new VBox(); 
        panelCentral.setAlignment(Pos.TOP_CENTER);
        
        /*Programación del título*/
        
        headingDevoluciones = new Label("Devoluciones");
        headingDevoluciones.setPrefWidth(1300);
        headingDevoluciones.setPrefHeight(120);
        headingDevoluciones.setAlignment(Pos.CENTER);
        headingDevoluciones.setStyle("-fx-font-size: 16pt;"
                + "-fx-background-color: #8a599c; "
                + "-fx-text-fill: white; "
                + "-fx-font-family: \"Verdana\";"
                + "-fx-font-weight: bold");
        panelCentral.getChildren().add(headingDevoluciones);
        
        /*Programación barra de búsqueda*/
        
        FlowPane barraBusqueda = new FlowPane();
        barraBusqueda.setHgap(25);
        barraBusqueda.setPadding(new Insets(15));
        
        devolucionesFilter = new Label("Busqueda por código de préstamo:");
        devolucionesFilter.setMinSize(233, 35); devolucionesFilter.setMaxSize(233, 35);
        devolucionesFilter.setAlignment(Pos.CENTER);
        
        TextField PrestamosSearchTF = new TextField();
        PrestamosSearchTF.setMinWidth(520);
        PrestamosSearchTF.setMaxWidth(520);
        
        devolucionesSearchButton = new Button("Buscar");
        devolucionesSearchButton.setOnAction(e -> {
            try {
                devolucionesSearchObservableList = Acciones.consultarDevoluciones(PrestamosSearchTF.getText());
                
                if (devolucionesSearchObservableList.isEmpty()){
                    String mensaje, title; 
                
                    if (idiomaSet.equals("Español")){
                        mensaje = "No se encontró el código de préstamo devuelto '"+PrestamosSearchTF.getText()+"'.";
                        title = "Elemento no encontrado";
                    } else {
                        mensaje = "Returned Loan ID '"+PrestamosSearchTF.getText()+"' not found";
                        title = "Item not found";
                    }
                    
                    Stage alert = new Stage(); 
                    StackPane sp = new StackPane(); 
                    alert.setTitle(title);
                    alert.initModality(Modality.APPLICATION_MODAL);

                    Label popUp = new Label(mensaje);
                    popUp.setStyle("-fx-font-family: \"Verdana\"; -fx-font-size: 18");
                    popUp.setPadding(new Insets(50));
                    sp.getChildren().add(popUp);
                    alert.setScene(new Scene(sp));
                    alert.show();
                } else {
                    DevolucionesTable.setItems(devolucionesSearchObservableList);
                    DevolucionesTable.refresh();
                }
            } catch (NumberFormatException nfe){
                String mensaje, title; 
                
                    if (idiomaSet.equals("Español")){
                        mensaje = "El código de préstamo devuelto debe ser un número.";
                        title = "Error de búsqueda";
                    } else {
                        mensaje = "Returned Loan ID must be a number";
                        title = "Search error";
                    }
                
                Stage alert = new Stage(); 
                StackPane sp = new StackPane(); 
                alert.setTitle(title);
                alert.initModality(Modality.APPLICATION_MODAL);

                Label popUp = new Label(mensaje);
                popUp.setStyle("-fx-font-family: \"Verdana\"; -fx-font-size: 18");
                popUp.setPadding(new Insets(50));
                sp.getChildren().add(popUp);
                alert.setScene(new Scene(sp));
                alert.show();
            }
            
            
        });
        
        devolucionesRevertirBusqueda = new Button("Revertir Búsqueda");
        devolucionesRevertirBusqueda.setMinSize(150, 30); devolucionesRevertirBusqueda.setMaxSize(150, 30);
        devolucionesRevertirBusqueda.setOnAction(e -> {
            devolucionesObservableList.clear();
            Acciones.listaDevueltos.recorridoListaSimple(devolucionesObservableList);
            DevolucionesTable.setItems(devolucionesObservableList);
            DevolucionesTable.setItems(devolucionesObservableList);
            DevolucionesTable.refresh();
        });
        
        barraBusqueda.getChildren().addAll(devolucionesFilter, PrestamosSearchTF, devolucionesSearchButton, devolucionesRevertirBusqueda);
        panelCentral.getChildren().add(barraBusqueda);
        
        
        /*Programación de la tabla*/
        
        TableColumn<Prestamo, Integer> codigoPrestamoColumn = new TableColumn("Código Préstamo");
        codigoPrestamoColumn.setCellValueFactory(new PropertyValueFactory<>("codigoPrestamo"));
        codigoPrestamoColumn.setStyle("-fx-alignment: center");
        
        TableColumn<Prestamo, Integer> fechaPrestamoColumn = new TableColumn("Fecha Préstamo");
        fechaPrestamoColumn.setCellValueFactory(new PropertyValueFactory<>("fechaSolicitud"));
        fechaPrestamoColumn.setStyle("-fx-alignment: center");
        
        TableColumn<Prestamo, String> nombreClienteColumn = new TableColumn("Cliente");
        nombreClienteColumn.setCellValueFactory(new PropertyValueFactory<>("nombreCliente"));
        nombreClienteColumn.setStyle("-fx-alignment: center");
        
        TableColumn<Prestamo, Integer> cedulaColumn = new TableColumn("Cédula");
        cedulaColumn.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        cedulaColumn.setStyle("-fx-alignment: center");
        
        TableColumn<Prestamo, String> librosColumn = new TableColumn("Libros");
        librosColumn.setCellValueFactory(new PropertyValueFactory<>("click"));
        librosColumn.setStyle("-fx-alignment: center");
        
        TableColumn<Prestamo, String> fechaDevolucionColumn = new TableColumn("Fecha Devolución");
        fechaDevolucionColumn.setCellValueFactory(new PropertyValueFactory<>("fechaDevolucion"));
        fechaDevolucionColumn.setStyle("-fx-alignment: center");
        
        TableColumn<Prestamo, String> estadoColumn = new TableColumn("Estado");
        estadoColumn.setCellValueFactory(new PropertyValueFactory<>("estado"));
        estadoColumn.setStyle("-fx-alignment: center");
        
        DevolucionesTable = new TableView<>();
        DevolucionesTable.setItems(devolucionesObservableList);
        DevolucionesTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        DevolucionesTable.setMinHeight(700);
        
        DevolucionesTable.getColumns().addAll(codigoPrestamoColumn, fechaPrestamoColumn, nombreClienteColumn, cedulaColumn, librosColumn, fechaDevolucionColumn, estadoColumn);
        
        panelCentral.getChildren().add(DevolucionesTable);
        
        if (idiomaSet.equals("Español")){
            this.cambiarIdioma("Español");
        } else {
            this.cambiarIdioma("Inglés");
        }
        
        return panelCentral;
    }
    
    /*Inicia la ejecución del elemento gráfico según la sintaxis de JavaFX. Asimismo, gestiona las acciones de los
      botones que le solicitan a los métodos de arriba la pantalla céntrica que debe mostrarse.*/
    @Override
    public void start(Stage primaryStage){
        mainStage = primaryStage;
        BorderPane bp = new BorderPane(); 
        
        Button[] vector = new Button[4];
        baseDatosButton = new Button("Base de Datos");
        prestamosButton = new Button("Préstamos");
        anulacionesButton = new Button("Anulaciones");
        devolucionesButton = new Button("Devoluciones");
        vector[0] = baseDatosButton; vector[1] = prestamosButton; vector[2] = anulacionesButton; vector[3] = devolucionesButton;

        for (Button b: vector){
            b.setPrefHeight(100);
            b.setPrefWidth(345);
            b.getStylesheets().add("sistemabiblioteca/CSS/Style.css/");
            
            b.setOnMouseEntered(e -> {
                b.setStyle("-fx-background-color: #2a0033");
            });
            b.setOnMouseExited(e -> {
                b.setStyle("fx-background-color: transparent");
            });
            
            b.setOnMousePressed(e -> {
                b.setStyle("-fx-text-fill: purple");
            });
            
            b.setOnMouseReleased(e -> {
                b.setStyle("fx-background-color: #2a0033");
            });
            
        }
        
        VBox panelIzq = new VBox(); 
        
        StackPane logoPane = new StackPane();
        logoPane.setPadding(new Insets(50));
        logoPane.setStyle("-fx-background-color: #2a0033");
        Image logo = new Image("file:LogoR2.png");
        ImageView imageview = new ImageView(logo);
        
        
        logoPane.getChildren().add(imageview);
        
        panelIzq.setSpacing(15);
        panelIzq.setAlignment(Pos.TOP_CENTER);
        panelIzq.setPrefWidth(300);
        panelIzq.setStyle("-fx-background-color: #390345");
        
        
        languageChooser = new ComboBox(); 
        languageChooser.getItems().addAll("Español", "Inglés");
        languageChooser.setPromptText("              Cambiar Idioma");
        languageChooser.setMinSize(297, 50);
        languageChooser.setStyle("-fx-background-color: white; -fx-font-size: 18;");
        languageChooser.setOnMouseEntered(e -> {
            languageChooser.setStyle("-fx-background-color: #ffc0ab; -fx-font-size: 18;");
        });
        languageChooser.setOnMouseExited(e -> {
            languageChooser.setStyle("-fx-background-color: white; -fx-font-size: 18;");
        });
        
        panelIzq.getChildren().addAll(logoPane, languageChooser, baseDatosButton, prestamosButton, anulacionesButton, devolucionesButton);
        
        languageChooser.setOnAction(e -> { 
            String idioma = languageChooser.getValue().toString();
            cambiarIdioma(idioma);
        });
        
        
        bp.setLeft(panelIzq);
        
        bp.setCenter(callBaseDatos());
        
        baseDatosButton.setOnAction(e -> {
            bp.setCenter(callBaseDatos());
        });
        
        anulacionesButton.setOnAction(e -> {
            bp.setCenter(callAnulaciones());
        });
        
        devolucionesButton.setOnAction(e -> {
            bp.setCenter(callDevoluciones());
        });
        
        prestamosButton.setOnAction(e -> {
            bp.setCenter(callPrestamos());
        });
       

        mainStage.setScene(new Scene(bp, 1368,768));
        mainStage.setTitle("Sistema Bibliotecario NAJM");
        mainStage.setResizable(false);
        
        if (idiomaSet.equals("Español")){
            this.cambiarIdioma("Español");
        } else {
            this.cambiarIdioma("Inglés");
        }
        
        mainStage.show();
   
    }
    
}

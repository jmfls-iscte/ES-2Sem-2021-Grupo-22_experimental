package com.poortoys.examples;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	private String path;
	private Scanner scanner; // Create a Scanner object
	private int n_reads;
	private ArrayList<String> cells;
	private ArrayList<Package> packages;
	private Package currentPackage;
	private Class currentClass;
	private Method currentMethod;

	private int currentCellInt;

	public ExcelRead() {
		// Scanner vai ser alterado quando GUI enviar path
		scanner = new Scanner(System.in);
		n_reads = 0;
		currentCellInt = 0;
		cells = new ArrayList<String>();
		packages = new ArrayList<Package>();

		System.out.println("Insira o caminho do ficheiro: ");
		path = scanner.nextLine();

	}

	public ExcelRead(String path) {
		this.path = path;
		n_reads = 0;
		currentCellInt = 0;
		cells = new ArrayList<String>();
		packages = new ArrayList<Package>();
	}

	public void ReadFile() {

		try {
			FileInputStream excelFile = new FileInputStream(new File(path));
			Workbook workbook = new XSSFWorkbook(excelFile);
			org.apache.poi.ss.usermodel.Sheet datatypeSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = datatypeSheet.iterator();

			while (iterator.hasNext()) {

				Row currentRow = iterator.next();
				Iterator<Cell> cellIterator = currentRow.iterator();

				currentCellInt = 0;
				currentClass = null;
				currentPackage = null;
				currentMethod = null;

				while (cellIterator.hasNext()) {

					Cell currentCell = cellIterator.next();

					if (currentCell.getCellTypeEnum() == CellType.STRING) {

						if (n_reads == 0) {
							/*
							 * Se n_reads = 0 significa que estou na linha do cabeçalho e extraio os nomes
							 * das colunas todas (MethodID--package--class--method--NOM_class--LOC_class...)
							 * E adiciono num array para posteriormente saber qual a métrica onde me
							 * encontro
							 */
							cells.add(currentCell.getStringCellValue());
						}

						System.out.print(currentCell.getStringCellValue() + "		");
					} else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
						System.out.print(currentCell.getNumericCellValue() + "		");
					} else if (currentCell.getCellTypeEnum() == CellType.BOOLEAN) {
						System.out.print(currentCell.getBooleanCellValue() + "		");
					}

					if (n_reads != 0) {
						switch (currentCellInt) {
						case 0:

							break;
						case 1:
							// criar ou verificar se existe package com o nome atual da célula
							String package_name = currentCell.getStringCellValue();
							for (Package p : packages) {
								if (p.getName_Package() == package_name)
									currentPackage = p;
							}

							if (currentPackage == null) {
								currentPackage = new Package(package_name);
								packages.add(currentPackage);
							}

							// currentCell.getStringCellValue()
							break;
						case 2:
							// criar ou verificar se existe classe com o nome atual da célula
							String class_name = currentCell.getStringCellValue();
							currentClass = currentPackage.get_ClassByName(class_name);
							if (currentClass == null) {
								currentClass = new Class(class_name);
								currentPackage.addClass(currentClass);
							}

							// currentCell.getStringCellValue()
							break;
						case 3:
							// criar ou verificar se existe metodo com o nome atual da célula
							// currentCell.getStringCellValue()
							break;

						default:
							/*
							 * verificar em que metrica estou com ajuda do array String metricaAtual =
							 * cells.get(currentCell);
							 * 
							 * Entrar no package Entrar na classe Entrar no metodo inserir metrica + valor
							 */

							break;
						}

						currentCellInt++;
					}
				}
				System.out.println();
				n_reads++;

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.print("So para parar");

	}

}

package com.qa.ComputingScraper;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class Logic {

	WebDriver driver = null;

	@Test

	public void testWithExcelJSoup() throws IOException, InterruptedException {

		FileInputStream file = new FileInputStream("C:\\Users\\Admin\\Desktop\\ComputingDDT.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);

		for (int i = 0; i < 2; i++) {

			Cell domain = sheet.getRow(i).getCell(0);
			Cell firstSelector = sheet.getRow(i).getCell(1);
			Cell secondSelector = sheet.getRow(i).getCell(2);

			String domainString = domain.getStringCellValue();
			String firstSelectorString = firstSelector.getStringCellValue();
			String secondSelectorString = secondSelector.getStringCellValue();

			Document doc = Jsoup.connect(domainString).get();

			Elements newsHeadlines = doc.select(firstSelectorString);
			
			for (Element headline : newsHeadlines) {
				Document doc2 = Jsoup.connect(headline.absUrl("href")).get();

				Elements secondEles = doc2.select(secondSelectorString);

				for (int k = 0; k < secondEles.text().length(); k++) {

					System.out.print(secondEles.text().charAt(k));
					if (k % 120 == 0) {
						System.out.println();
					}
				}
				System.out.println();
				System.out.println("---------------------------------------------------------------------");

			}

		}

	}

}

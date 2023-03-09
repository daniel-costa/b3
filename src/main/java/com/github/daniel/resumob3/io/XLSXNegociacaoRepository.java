package com.github.daniel.resumob3.io;

import com.github.daniel.resumob3.domain.negociacao.Negociacao;
import com.github.daniel.resumob3.domain.negociacao.NegociacaoRepository;
import com.github.daniel.resumob3.domain.negociacao.TipoDeMovimentacao;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class XLSXNegociacaoRepository implements NegociacaoRepository {
    @Override
    public List<Negociacao> load(InputStream input) {
        List<Negociacao> todas = new ArrayList<>();
        try {
            // create an XSSF Workbook object for our XLSX Execel file
            XSSFWorkbook workbook = new XSSFWorkbook(input);
            // get the first sheet
            XSSFSheet firstSheet = workbook.getSheetAt(0);
            // iterator on rows, sheet is a collection of rows
            Iterator<Row> rowIterator = firstSheet.iterator();

            rowIterator.next();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                Iterator<Cell> cellIterator = row.iterator();
                String date = cellIterator.next().getStringCellValue();
                Date dataDoNegocio = new SimpleDateFormat("dd/MM/yyyy").parse(date);
                TipoDeMovimentacao tipoDeNegociacao = TipoDeMovimentacao
                        .valueOf(cellIterator.next()
                                .getStringCellValue().toUpperCase());
                cellIterator.next();
                cellIterator.next();
                String corretora = cellIterator.next().getStringCellValue();
                String ativo = cellIterator.next().getStringCellValue();
                double quantidadeNegociada = cellIterator.next()
                        .getNumericCellValue();
                double precoNegociado = cellIterator.next().getNumericCellValue();
                double valorTotalNegociado = cellIterator.next().getNumericCellValue();

                todas.add(new Negociacao(dataDoNegocio, tipoDeNegociacao, corretora, ativo, (int)quantidadeNegociada, precoNegociado, valorTotalNegociado));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return todas;
    }


}

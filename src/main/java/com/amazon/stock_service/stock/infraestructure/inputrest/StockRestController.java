package com.amazon.stock_service.stock.infraestructure.inputrest;

import com.amazon.stock_service.stock.application.dto.StockRequest;
import com.amazon.stock_service.stock.application.handler.IStockHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock")
@RequiredArgsConstructor
public class StockRestController {

    private  final IStockHandler stockHandler;

    @Operation(summary = "Add a new category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Category created",content = @Content),
            @ApiResponse(responseCode = "409", description = "Category already exists", content = @Content)
    })
    @PostMapping("/")
    public ResponseEntity<Void> saveCategoryInStock(@RequestBody StockRequest stockRequest){
        stockHandler.saveCategoryInStock(stockRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}

package com.dunhill.car_rental.controller;

import com.dunhill.car_rental.dtos.CreateRefundDto;
import com.dunhill.car_rental.dtos.ResponseRefundDto;
import com.dunhill.car_rental.service.RefundService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/api/refunds")
@RestController
@Tag(name = "CRUD REST APIs for Refund Resource")
public class RefundController {

    private final RefundService refundService;

    @Operation(summary = "Create Refund REST API", description = "Creates a new refund based on the provided refund details.")
    @ApiResponse(responseCode = "201", description = "Http Status 201 CREATED")
    @PostMapping
    public ResponseEntity<ResponseRefundDto> createRefund(@Valid @RequestBody CreateRefundDto createRefundDto) {
        ResponseRefundDto refund = refundService.save(createRefundDto);
        return new ResponseEntity<>(refund, HttpStatus.CREATED);
    }

    @Operation(summary = "Retrieve All Refunds REST API", description = "Fetches a list of all existing refunds.")
    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
    @GetMapping("/all")
    public ResponseEntity<List<ResponseRefundDto>> getAllRefunds() {
        List<ResponseRefundDto> refunds = refundService.getAll();
        return ResponseEntity.ok(refunds);
    }

    @Operation(summary = "Update Refund REST API", description = "Updates a specific refund based on its ID.")
    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
    @PutMapping("/{id}")
    public ResponseEntity<ResponseRefundDto> updateRefund(@Valid @RequestBody CreateRefundDto createRefundDto, @PathVariable Long id) {
        ResponseRefundDto updatedRefund = refundService.update(createRefundDto, id);
        return ResponseEntity.ok(updatedRefund);
    }

    @Operation(summary = "Delete Refund REST API", description = "Deletes a specific refund by its ID.")
    @ApiResponse(responseCode = "204", description = "Http Status 204 NO CONTENT")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRefund(@PathVariable Long id) {
        refundService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

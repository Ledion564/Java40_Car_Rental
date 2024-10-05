package com.dunhill.car_rental.controller;

import com.dunhill.car_rental.Dtos.CreateRefundDto;
import com.dunhill.car_rental.Dtos.ResponseRefundDto;
import com.dunhill.car_rental.Entity.Refund;
import com.dunhill.car_rental.service.RefundService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RequestMapping("/refund")
@RestController
public class RefundController {

    private RefundService refundService;

    @PostMapping
    public ResponseEntity<ResponseRefundDto> save(@RequestBody CreateRefundDto createRefundDto){
        return ResponseEntity.ok(refundService.save(createRefundDto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ResponseRefundDto>> getAll(){
        return ResponseEntity.ok(refundService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseRefundDto> update(@RequestBody CreateRefundDto createRefundDto, @PathVariable Long id){
        return ResponseEntity.ok(refundService.update(createRefundDto, id));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam("refundId") Long id){
        refundService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

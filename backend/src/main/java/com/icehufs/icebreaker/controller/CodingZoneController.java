package com.icehufs.icebreaker.controller;



import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import com.icehufs.icebreaker.service.CodingZoneService;

import com.icehufs.icebreaker.dto.response.codingzone.*;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/coding-zone")
@RequiredArgsConstructor
public class CodingZoneController {
    private final CodingZoneService codingzoneService;
 
    @GetMapping("/auth-type")
    public ResponseEntity<? super AuthorityExistResponseDto> authExist(
    @AuthenticationPrincipal String email
    ){
        ResponseEntity<? super AuthorityExistResponseDto> response = codingzoneService.authExist(email);
        return response;
    }

    @PostMapping("/reserve-class/{classNum}")
    public ResponseEntity<? super CodingZoneRegisterResponseDto> classRegist(
        @PathVariable Integer classNum,
        @AuthenticationPrincipal String email
        ){
            ResponseEntity<? super CodingZoneRegisterResponseDto> response = codingzoneService.classRegist(classNum, email);
            return response;
        }
    
    @DeleteMapping("/cence-class/{classNum}")
    public ResponseEntity<? super CodingZoneCanceResponseDto> classCence(
        @PathVariable Integer classNum,
        @AuthenticationPrincipal String email
        ){
            ResponseEntity<? super CodingZoneCanceResponseDto> response = codingzoneService.classCance(classNum, email);
            return response;
        }

    @GetMapping("/class-list/{grade}") //코딩존 메인 페이지에서 로그인 된 사용자를 위한 수업들 나열 API
    public ResponseEntity<? super GetListOfCodingZoneClassResponseDto> getClassList(
        @PathVariable Integer grade,
        @AuthenticationPrincipal String email
    ){
        ResponseEntity<? super GetListOfCodingZoneClassResponseDto> response = codingzoneService.getClassList(grade, email);
        return response;
    }

    @GetMapping("/class-list/for-not-login/{grade}") //코딩존 메인 페이지에서 로그인 안된 사용자를 위한 수업들 나열 API
    public ResponseEntity<? super GetListOfCodingZoneClassForNotLogInResponseDto> getClassList2(
        @PathVariable Integer grade
    ){
        ResponseEntity<? super GetListOfCodingZoneClassForNotLogInResponseDto> response = codingzoneService.getClassList2(grade);
        return response;
    } 
    
    @GetMapping("/count-of-attend/{grade}")
    public ResponseEntity<? super GetCountOfAttendResponseDto> getCountAttend(
        @PathVariable Integer grade,
        @AuthenticationPrincipal String email
    ){
        ResponseEntity<? super GetCountOfAttendResponseDto> response = codingzoneService.getAttend(grade, email);
        return response;
    }   

    @GetMapping("/attend-list")
    public ResponseEntity<? super GetPersAttendListItemResponseDto> getPerAttendList(
        @AuthenticationPrincipal String email
    ){
        ResponseEntity<? super GetPersAttendListItemResponseDto> response = codingzoneService.getPerAttendList(email);
        return response;
    } 

    @GetMapping("/reserved-list/{classDate}")
    public ResponseEntity<? super GetReservedClassListItemResponseDto> getReservedList(
        @PathVariable String classDate,
        @AuthenticationPrincipal String email
    ){
        ResponseEntity<? super GetReservedClassListItemResponseDto> response = codingzoneService.getReservedClass(classDate, email);
        return response;
    } 

    @GetMapping("/assistant-list")
    public ResponseEntity<? super GetCodingZoneAssitantListResponseDto> getAssistantList(
    ){
        ResponseEntity<? super GetCodingZoneAssitantListResponseDto> response = codingzoneService.getAssistantList();
        return response;
    } 

}

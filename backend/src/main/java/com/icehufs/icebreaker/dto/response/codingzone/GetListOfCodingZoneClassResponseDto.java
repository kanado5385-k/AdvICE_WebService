package com.icehufs.icebreaker.dto.response.codingzone;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.icehufs.icebreaker.common.ResponseCode;
import com.icehufs.icebreaker.common.ResponseMessage;
import com.icehufs.icebreaker.dto.object.CodingZoneClassListItem;
import com.icehufs.icebreaker.dto.response.ResponseDto;
import com.icehufs.icebreaker.entity.CodingZoneClass;

import lombok.Getter;

@Getter
public class GetListOfCodingZoneClassResponseDto extends ResponseDto{

    private List<CodingZoneClassListItem> classList;
    private int registedClassNum;

    private GetListOfCodingZoneClassResponseDto(int registedClassNum,List<CodingZoneClass> CodingZoneClassListEntities){
    super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    this.registedClassNum = registedClassNum;
    this.classList = CodingZoneClassListItem.getList(CodingZoneClassListEntities);
    }

    public static ResponseEntity<GetListOfCodingZoneClassResponseDto> success(int registedClassNum,List<CodingZoneClass> CodingZoneClassListEntities){
        GetListOfCodingZoneClassResponseDto result = new GetListOfCodingZoneClassResponseDto(registedClassNum, CodingZoneClassListEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistUser (){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_USER, ResponseMessage.NOT_EXISTED_USER);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
    }

    public static ResponseEntity<ResponseDto> noExistArticle(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_ARTICLE, ResponseMessage.NOT_EXISTED_ARTICLE);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
    
}

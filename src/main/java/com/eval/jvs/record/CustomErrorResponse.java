package com.eval.jvs.record;

import java.time.LocalDateTime;

public record CustomErrorResponse(

        LocalDateTime timestamp,
        String message,
        String path
    
    ) {
    
}

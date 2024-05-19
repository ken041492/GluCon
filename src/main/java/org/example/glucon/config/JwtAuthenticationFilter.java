package org.example.glucon.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component // 將這個過濾器作為組件添加到Spring容器中，以便Spring自動管理
@RequiredArgsConstructor // 由Lombok生成一个包含所有final字段的構造函數
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        // 從HTTP請求中獲取Authorization頭的值
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String userAccount;
        // 檢查Authorization頭部是否存在，並且是否以Bearer開頭
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response); // // 如果不符合，則進行下一個過濾器處理
            return;
        }

        jwt = authHeader.substring(7); // 取得jwt字串符
        userAccount = jwtService.extractUsername(jwt);
        // 獲取目前認證訊息
        if (userAccount != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userAccount); // 獲得用户訊息
            if(jwtService.isTokenValid(jwt, userDetails)) {
                // 生成一個UsernamePasswordAuthenticationToken認證信息
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null, // // 密码通常验证后不再需要，所以这里是null
                        userDetails.getAuthorities() // // 用户的权限
                );
                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                // 将认证信息存储到SecurityContextHolder，这样就通过了Security的认证
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        // 继续请求的处理
        filterChain.doFilter(request, response);
    }
}

//package com.fixadate.fixadate.jwt.filter;
//
//import java.io.IOException;
//
//import com.fixadate.fixadate.jwt.service.JwtService;
//
//
//import com.fixadate.fixadate.member.repository.MemberRepository;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
//import org.springframework.security.core.authority.mapping.NullAuthoritiesMapper;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@RequiredArgsConstructor
//public class JwtRequestFilter extends OncePerRequestFilter {
//
//    private final MemberRepository memberRepository;
//    private final JwtService jwtService;
//
//    private GrantedAuthoritiesMapper authoritiesMapper = new NullAuthoritiesMapper();
//
//    @Value("${NO_CHECK_URL}")
//    private final String NO_CHECK_URL;
//
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        if (request.getRequestURI().equals(NO_CHECK_URL)) {
//            filterChain.doFilter(request, response);
//            return;
//        }
//
//        String refreshToken = jwtService
//                .extractRefreshToken(request)
//                .filter(jwtService::isTokenValid)
//                .orElse(null);
//
//        if (refreshToken != null) {
//            checkRefreshTokenAndReIssueAccessToken(response, refreshToken);
//            return;
//        }
//
//        checkAccessTokenAndAuthentication(request, response, filterChain);
//    }
//
//    private void checkAccessTokenAndAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        jwtService.extractAccessToken(request).filter(jwtService::isTokenValid).ifPresent(
//
//                accessToken -> jwtService.extractGitID(accessToken).ifPresent(
//
//                        gitId -> memberRepository.findByGitID(gitId).ifPresent(
//                                this::saveAuthentication
//                        )
//                )
//        );
//
//        filterChain.doFilter(request, response);
//    }
//
//    private void saveAuthentication(Member member) {
//        UserDetails user = User.builder()
//                .username(member.getGitID())
//                .password(member.getRefreshToken())
//                .roles("user")
//                .build();
//
//        Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, authoritiesMapper.mapAuthorities(user.getAuthorities()));
//
//        SecurityContext context = SecurityContextHolder.createEmptyContext();
//        context.setAuthentication(authentication);
//        SecurityContextHolder.setContext(context);
//    }
//
//    private voidA
//    }
//
//}
//

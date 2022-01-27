package shop.janghj.mytrip.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.janghj.mytrip.domain.Bookmark;
import shop.janghj.mytrip.domain.User;
import shop.janghj.mytrip.repository.BookmarkRepository;
import shop.janghj.mytrip.repository.UserRepository;
import shop.janghj.mytrip.security.UserDetailsImpl;
import shop.janghj.mytrip.dto.BookmarkDto;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookmarkService {
    private final BookmarkRepository bookmarkRepository;
    private final UserRepository userRepository;

    public List<Bookmark> findBookmarks(Long userId, String type) {
        return bookmarkRepository.findAllByUserIdAndType(userId, type);
    }

    @Transactional
    public void deleteBookmark(Long contentId, UserDetailsImpl nowUser) {
        bookmarkRepository.deleteByContentIdAndUserId(contentId, nowUser.getId());
    }

    @Transactional
    public Bookmark saveBookmark(Long contentId, String type, BookmarkDto bookmarkDto, UserDetailsImpl nowUser) {
        User user = userRepository.findById(nowUser.getId()).orElseThrow(
                () -> new NullPointerException("해당 User 없음")
        );
        Bookmark bookmark = new Bookmark(contentId, type, bookmarkDto, user);
        return bookmarkRepository.save(bookmark);
    }

    public Bookmark checkBookmarkStatus(Long contentId, Long userId) {
        return bookmarkRepository.findByContentIdAndUserId(contentId, userId);
    }

}
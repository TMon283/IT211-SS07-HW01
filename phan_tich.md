# Phân tích

Trong TransactionService hiện tại, việc chèn thủ công System.currentTimeMillis() vào đầu và cuối mỗi phương thức để đo thời gian thực thi đã vi phạm nguyên tắc Separation of Concerns (Phân tách mối quan tâm) trong thiết kế phần mềm.

- Logic nghiệp vụ (xử lý thanh toán) bị trộn lẫn với logic kỹ thuật (ghi log hiệu năng).
- Dẫn đến Code Tangling: mã lặp lại, rối rắm, khó bảo trì.
- Khi cần thay đổi cách đo hiệu năng, phải sửa nhiều phương thức, dễ gây lỗi.

Giải pháp: Tách riêng logic đo hiệu năng ra khỏi Service bằng cách sử dụng Spring AOP với @Around Advice.

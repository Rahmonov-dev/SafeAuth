# SafeAuth

**SafeAuth** — bu foydalanuvchilarni ro'yxatga olish va tizimga kirish funksiyalarini taqdim etuvchi Java asosidagi autentifikatsiya tizimi. Ushbu loyiha foydalanuvchilarni xavfsiz ro'yxatga olish va tizimga kirish jarayonlarini amalga oshirishni ko'zda tutadi.

## Foydalanish

### Talablar

- Java 11 yoki undan yuqori versiya
- Java IDE (IntelliJ IDEA, Eclipse, yoki boshqa)
- Git (opsional, kodni repozitoriyaga yuklash uchun)

### Loyiha tarkibi

1. **Foydalanuvchi ro'yxatga olish**: Foydalanuvchi ismi, email, telefon raqami va parolni kiritib, ro'yxatdan o'tish mumkin.
2. **Tizimga kirish**: Email va parol orqali foydalanuvchi tizimga kirishi mumkin.
3. **Foydalanuvchi ma'lumotlarini tekshirish**: Foydalanuvchi email va parol asosida tizimga kirishi tekshiriladi.

### Dasturga qanday ishlatish

1. **Kodni olish**:
    ```bash
    git clone https://github.com/username/SafeAuth.git
    ```

2. **Dasturga kirish va ishga tushirish**:
    - Dastur Java dasturlash tilida yozilgan va uni `Main` klassini ishga tushirish orqali boshlashingiz mumkin.
    - Konsolga quyidagi menyu chiqadi:
      ```
      1-Login
      2-Register
      3-Exit
      ```
        - **Login**: Tizimga kirish.
        - **Register**: Yangi foydalanuvchi ro'yxatdan o'tishi.
        - **Exit**: Dasturdan chiqish.

### Ma'lumotlar saqlanishi

Dastur foydalanuvchi ma'lumotlarini **user.txt** faylida saqlaydi.

### Xatoliklarni tuzatish

Agar siz `Serializable` xatosini ko'rsangiz, `User` sinfini `Serializable` interfeysini amalga oshiring.

### Yordam

Agar sizda biron-bir savol yoki muammo bo'lsa, loyiha sahifasiga murojaat qiling yoki menga yozing.

---

Loyiha yaratishdagi asosiy maqsad foydalanuvchi ro'yxatga olish va tizimga kirish funksiyalarini o'rganish va amalga oshirishdir.
